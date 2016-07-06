/**
 * Your application code goes here<br>
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose
 * of building native mobile applications using Java.
 */


package userclasses;

import com.codename1.analytics.AnalyticsService;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.maps.Coord;
import com.codename1.maps.MapComponent;
import com.codename1.maps.layers.PointLayer;
import com.codename1.maps.layers.PointsLayer;
import com.codename1.maps.providers.GoogleMapsProvider;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.g_ara.gara.RequestsHandler;
import generated.StateMachineBase;

/**
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {
    private final RequestsHandler requestsHandler = new RequestsHandler();
    PointLayer distPoint;
    PointsLayer distLayer;
    Long pointerPressed;
    int pointerPressedX, pointerPressedY;

    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }

    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    protected void initVars(Resources res) {
    }


    @Override
    protected void onCreateMainScreen() {

    }

    @Override
    protected void onLogin_BtnLoginAction(Component c, ActionEvent event) {
        String username = findUsername().getText();
        String password = findPassword().getText();

        ConnectionRequest request = requestsHandler.loginAsync(username, password);
        if (request.getResponseCode() == 201) {
            ToastBar.showErrorMessage("logged in");
            String msg = new String(request.getResponseData());

            showForm("MainScreen", null);
        } else {
            ToastBar.showErrorMessage("incorrect username or password");
        }
    }


    @Override
    protected void beforeMainScreen(Form f) {


        Image image = fetchResourceFile().getImage("map-pin-blue-hi.png");
        String name = "You are here!";
        PointsLayer pointsLayer = new PointsLayer();
        Coord position;
        try {
            Location currentLocation = LocationManager.getLocationManager().getCurrentLocation();
            position = new Coord(currentLocation.getLatitude(), currentLocation.getLongitude());
        } catch (Exception e) {
            e.printStackTrace();
            AnalyticsService.sendCrashReport(e, e.getMessage(), false);
            Dialog.show("error", e.getMessage(), "ok", null);

            Location currentLocation = LocationManager.getLocationManager().getLastKnownLocation();
            position = new Coord(currentLocation.getLatitude(), currentLocation.getLongitude());
        }
        MapComponent mapComponent = new MapComponent(new GoogleMapsProvider("AIzaSyAxlzXskkl3KKdjZUuFrV-j8oFjWOjtTIQ"), position, 5, true);
        PointLayer pointLayer = new PointLayer(position, name, image);
        pointLayer.setDisplayName(true);
        pointsLayer.addPoint(pointLayer);
        mapComponent.addLayer(pointsLayer);
        f.addComponent(BorderLayout.CENTER, mapComponent);


//            findMapComponent().addMapListener((source, zoom, center) -> {
//
//                PointsLayer pointsLayer1 = new PointsLayer();
//                Image image1 = fetchResourceFile().getImage("map-pin-green-hi.png");
//                String name1 = "Your Dist!";
//                Coord coord = new Coord(center.getLatitude(), center.getLongitude());
//                PointLayer pointLayer1 = new PointLayer(coord, name1, image1);
//                pointLayer1.setDisplayName(true);
////                pointLayer1.setProjected(true);
////
////                pointsLayer1.addPoint(pointLayer1);
////                MapComponent mapComponent = findMapComponent();
////                PointsLayer layerAt = (PointsLayer) mapComponent.getLayerAt(0);
////                layerAt.addPoint(pointLayer1);
//////                mapComponent.addLayer(pointsLayer1);
////                mapComponent.removeAllLayers();
////                mapComponent.addLayer(layerAt);
////                mapComponent.repaint();
////                f.repaint();
//////                f.refreshTheme();
//////                f.revalidate();
//
//
//                MapComponent mapComponent = findMapComponent();
//                PointsLayer layerAt = (PointsLayer) mapComponent.getLayerAt(0);
//                layerAt.addPoint(pointLayer1);
//                f.removeAll();
//                f.addComponent(mapComponent);
////                mapComponent.repaint();
////                f.repaint();
//
//            });

//            findMapComponent().addMapListener(new MapListener() {
//                @Override
//                public void mapPositionUpdated(Component source, int zoom, Coord center) {
//                Image image1 = fetchResourceFile().getImage("map-pin-green-hi.png");
//                String name1 = "Your Dist!";
//                Coord coord = new Coord(center.getLatitude(), center.getLongitude());
//                    Coord coordFromPosition = findMapComponent().getCoordFromPosition(source.getX(), source.getY());
//                    Coord coordFromPosition1 = findMapComponent().getCoordFromPosition(source.getAbsoluteX(), source.getAbsoluteY());
//
//                    System.out.println(source);
//                    PointLayer pointLayer1 = new PointLayer(coord,name1,image1);
//                    PointsLayer pointsLayer1 = new PointsLayer();
//                    pointsLayer1.addPoint(pointLayer1);
//                    findMapComponent().addLayer(pointsLayer1);
//                }
//
//            });

        mapComponent.addPointerPressedListener(evt ->
                {
                    pointerPressed = System.currentTimeMillis();
                    pointerPressedX = evt.getX();
                    pointerPressedY = evt.getY();
                }
        );
        mapComponent.addPointerReleasedListener(evt -> {
            int x = evt.getX();
            int y = evt.getY();

            final boolean longTap = (System.currentTimeMillis() - pointerPressed >= 200) && Math.abs(x - pointerPressedX) <= 10 && Math.abs(y - pointerPressedY) <= 10;
            if (longTap) {
                Image image1 = fetchResourceFile().getImage("map-pin-green-hi.png");
                String name1 = "Your Dist!";
                Coord coord = mapComponent.getCoordFromPosition(evt.getX(), evt.getY());

                distPoint = new PointLayer(coord, name1, image1);
                distPoint.setDisplayName(true);
                distLayer = new PointsLayer();
                distLayer.addPoint(distPoint);

                while (mapComponent.getLayersConut() > 1)
                    mapComponent.removeLayer(mapComponent.getLayerAt(1));

                mapComponent.addLayer(distLayer);
            }
        });


    }


    @Override
    protected void onGUI1_ButtonAction(Component c, ActionEvent event) {

    }


    @Override
    protected void onRegister_RegisterAction(Component c, ActionEvent event) {

        String username = findUsername().getText();
        String name = findName().getText();
        String password = findPassword().getText();
        String phone = findPhone().getText();
        String email = findEmail().getText();

        ConnectionRequest request = requestsHandler.registerSync(username, name, password, phone, email);

        if (request.getResponseCode()==201) {
            ToastBar.showErrorMessage("Registered");
            String msg = new String(request.getResponseData());

            showForm("MainScreen", null);
        } else {
            String msg = new String(request.getResponseData());
//            String error="";
//            try {
//                JSONObject jsonObject = new JSONObject(msg);
////               error=  jsonObject.optString("password");
////                error+="\n"+ jsonObject.optString("studentemail");
////                error+="\n"+ jsonObject.optString("name");
////                error+="\n"+ jsonObject.optString("username");
////                error+="\n"+ jsonObject.optString("password");
////                error+="\n"+ jsonObject.optString("phonenumber");
//                findName().setUIID((jsonObject.has("name"))?"TextAreaRed":"TextArea");
//                findEmail().setUIID((jsonObject.has("studentemail"))?"TextAreaRed":"TextArea");
//                findUsername().setUIID((jsonObject.has("username"))?"TextAreaRed":"TextArea");
//                findPassword().setUIID((jsonObject.has("password"))?"TextAreaRed":"TextArea");
//                findPhone().setUIID((jsonObject.has("phonenumber"))?"TextAreaRed":"TextArea");
//
//                c.getParent().repaint();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            ToastBar.showErrorMessage("something went wrong!");
        }
    }

    @Override
    protected void beforeRegister(Form f) {
        Validator v = new Validator();
        v.addConstraint(findName(), new RegexConstraint("[aA-zZ ]{5,}", "Must be valid name")).
                addConstraint(findEmail(), RegexConstraint.validEmail("Email should be valid")).
                addConstraint( findUsername(), new RegexConstraint("[A-Za-z0-9_]+", "username should be valid")).
                addConstraint(findPhone(), new RegexConstraint("[0-9]{10,}", "Must be valid phone number")).
                addConstraint(findPassword(),new RegexConstraint(".{6,}","Password should be complex"));
        v.addSubmitButtons(findRegister());
    }

    @Override
    protected void beforeLogin(Form f) {
        Validator v = new Validator();
        v.addConstraint( findUsername(), new RegexConstraint("[A-Za-z0-9_]+", "username should be valid")).
                addConstraint(findPassword(),new RegexConstraint(".{6,}","Password should be complex"));
        v.addSubmitButtons(findBtnLogin());
    }
}
