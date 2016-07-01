/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import java.util.Hashtable;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("MapComponent", com.codename1.maps.MapComponent.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "Login";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("MapComponent", com.codename1.maps.MapComponent.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Login");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.TextArea findEmail(Component root) {
        return (com.codename1.ui.TextArea)findByName("Email", root);
    }

    public com.codename1.ui.TextArea findEmail() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("Email", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("Email", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findLogo(Component root) {
        return (com.codename1.ui.Button)findByName("Logo", root);
    }

    public com.codename1.ui.Button findLogo() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Logo", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Logo", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findCPassword(Component root) {
        return (com.codename1.ui.TextArea)findByName("CPassword", root);
    }

    public com.codename1.ui.TextArea findCPassword() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("CPassword", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("CPassword", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnNoAccount(Component root) {
        return (com.codename1.ui.Button)findByName("BtnNoAccount", root);
    }

    public com.codename1.ui.Button findBtnNoAccount() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnNoAccount", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnNoAccount", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findUsername(Component root) {
        return (com.codename1.ui.TextArea)findByName("Username", root);
    }

    public com.codename1.ui.TextArea findUsername() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("Username", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("Username", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnLogin(Component root) {
        return (com.codename1.ui.Button)findByName("BtnLogin", root);
    }

    public com.codename1.ui.Button findBtnLogin() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnLogin", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnLogin", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Component findRegister(Component root) {
        return (com.codename1.ui.Component)findByName("Register", root);
    }

    public com.codename1.ui.Component findRegister() {
        com.codename1.ui.Component cmp = (com.codename1.ui.Component)findByName("Register", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Component)findByName("Register", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findPhone(Component root) {
        return (com.codename1.ui.TextArea)findByName("Phone", root);
    }

    public com.codename1.ui.TextArea findPhone() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("Phone", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("Phone", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.maps.MapComponent findMapComponent(Component root) {
        return (com.codename1.maps.MapComponent)findByName("MapComponent", root);
    }

    public com.codename1.maps.MapComponent findMapComponent() {
        com.codename1.maps.MapComponent cmp = (com.codename1.maps.MapComponent)findByName("MapComponent", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.maps.MapComponent)findByName("MapComponent", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findProfilePic(Component root) {
        return (com.codename1.ui.Button)findByName("ProfilePic", root);
    }

    public com.codename1.ui.Button findProfilePic() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("ProfilePic", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("ProfilePic", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findPassword(Component root) {
        return (com.codename1.ui.TextArea)findByName("Password", root);
    }

    public com.codename1.ui.TextArea findPassword() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("Password", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("Password", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findBtnHaveAccount(Component root) {
        return (com.codename1.ui.Button)findByName("BtnHaveAccount", root);
    }

    public com.codename1.ui.Button findBtnHaveAccount() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("BtnHaveAccount", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("BtnHaveAccount", aboutToShowThisContainer);
        }
        return cmp;
    }

    public static final int COMMAND_LoginDonTHaveAnAccountRegisterNow = 4;
    public static final int COMMAND_MainScreenDriverArea = 8;
    public static final int COMMAND_MainScreenBecomeADriver = 7;
    public static final int COMMAND_RegisterAlreadyAMemberLogin = 2;
    public static final int COMMAND_LoginLogin = 5;
    public static final int COMMAND_MainScreenLogout = 12;
    public static final int COMMAND_MainScreenSettings = 10;
    public static final int COMMAND_MainScreenChat = 11;
    public static final int COMMAND_MainScreenProfile = 9;
    public static final int COMMAND_MainScreenHome = 6;
    public static final int COMMAND_RegisterRegister = 1;

    protected boolean onLoginDonTHaveAnAccountRegisterNow() {
        return false;
    }

    protected boolean onMainScreenDriverArea() {
        return false;
    }

    protected boolean onMainScreenBecomeADriver() {
        return false;
    }

    protected boolean onRegisterAlreadyAMemberLogin() {
        return false;
    }

    protected boolean onLoginLogin() {
        return false;
    }

    protected boolean onMainScreenLogout() {
        return false;
    }

    protected boolean onMainScreenSettings() {
        return false;
    }

    protected boolean onMainScreenChat() {
        return false;
    }

    protected boolean onMainScreenProfile() {
        return false;
    }

    protected boolean onMainScreenHome() {
        return false;
    }

    protected boolean onRegisterRegister() {
        return false;
    }

    protected void processCommand(ActionEvent ev, Command cmd) {
        switch(cmd.getId()) {
            case COMMAND_LoginDonTHaveAnAccountRegisterNow:
                if(onLoginDonTHaveAnAccountRegisterNow()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainScreenDriverArea:
                if(onMainScreenDriverArea()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainScreenBecomeADriver:
                if(onMainScreenBecomeADriver()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_RegisterAlreadyAMemberLogin:
                if(onRegisterAlreadyAMemberLogin()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_LoginLogin:
                if(onLoginLogin()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainScreenLogout:
                if(onMainScreenLogout()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainScreenSettings:
                if(onMainScreenSettings()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainScreenChat:
                if(onMainScreenChat()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainScreenProfile:
                if(onMainScreenProfile()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainScreenHome:
                if(onMainScreenHome()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_RegisterRegister:
                if(onRegisterRegister()) {
                    ev.consume();
                    return;
                }
                break;

        }
        if(ev.getComponent() != null) {
            handleComponentAction(ev.getComponent(), ev);
        }
    }

    protected void exitForm(Form f) {
        if("Login".equals(f.getName())) {
            exitLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(f.getName())) {
            exitMainScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Register".equals(f.getName())) {
            exitRegister(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitLogin(Form f) {
    }


    protected void exitMainScreen(Form f) {
    }


    protected void exitRegister(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("Login".equals(f.getName())) {
            beforeLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(f.getName())) {
            beforeMainScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Register".equals(f.getName())) {
            beforeRegister(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeLogin(Form f) {
    }


    protected void beforeMainScreen(Form f) {
    }


    protected void beforeRegister(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("Login".equals(c.getName())) {
            beforeContainerLogin(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(c.getName())) {
            beforeContainerMainScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Register".equals(c.getName())) {
            beforeContainerRegister(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerLogin(Container c) {
    }


    protected void beforeContainerMainScreen(Container c) {
    }


    protected void beforeContainerRegister(Container c) {
    }

    protected void postShow(Form f) {
        if("Login".equals(f.getName())) {
            postLogin(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(f.getName())) {
            postMainScreen(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Register".equals(f.getName())) {
            postRegister(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postLogin(Form f) {
    }


    protected void postMainScreen(Form f) {
    }


    protected void postRegister(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("Login".equals(c.getName())) {
            postContainerLogin(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(c.getName())) {
            postContainerMainScreen(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Register".equals(c.getName())) {
            postContainerRegister(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerLogin(Container c) {
    }


    protected void postContainerMainScreen(Container c) {
    }


    protected void postContainerRegister(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("Login".equals(rootName)) {
            onCreateLogin();
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(rootName)) {
            onCreateMainScreen();
            aboutToShowThisContainer = null;
            return;
        }

        if("Register".equals(rootName)) {
            onCreateRegister();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateLogin() {
    }


    protected void onCreateMainScreen() {
    }


    protected void onCreateRegister() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("Login".equals(f.getName())) {
            getStateLogin(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("MainScreen".equals(f.getName())) {
            getStateMainScreen(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Register".equals(f.getName())) {
            getStateRegister(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateLogin(Form f, Hashtable h) {
    }


    protected void getStateMainScreen(Form f, Hashtable h) {
    }


    protected void getStateRegister(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("Login".equals(f.getName())) {
            setStateLogin(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("MainScreen".equals(f.getName())) {
            setStateMainScreen(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Register".equals(f.getName())) {
            setStateRegister(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateLogin(Form f, Hashtable state) {
    }


    protected void setStateMainScreen(Form f, Hashtable state) {
    }


    protected void setStateRegister(Form f, Hashtable state) {
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("Login")) {
            if("Logo".equals(c.getName())) {
                onLogin_LogoAction(c, event);
                return;
            }
            if("Username".equals(c.getName())) {
                onLogin_UsernameAction(c, event);
                return;
            }
            if("Password".equals(c.getName())) {
                onLogin_PasswordAction(c, event);
                return;
            }
            if("BtnLogin".equals(c.getName())) {
                onLogin_BtnLoginAction(c, event);
                return;
            }
            if("BtnNoAccount".equals(c.getName())) {
                onLogin_BtnNoAccountAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Register")) {
            if("ProfilePic".equals(c.getName())) {
                onRegister_ProfilePicAction(c, event);
                return;
            }
            if("Username".equals(c.getName())) {
                onRegister_UsernameAction(c, event);
                return;
            }
            if("Email".equals(c.getName())) {
                onRegister_EmailAction(c, event);
                return;
            }
            if("Password".equals(c.getName())) {
                onRegister_PasswordAction(c, event);
                return;
            }
            if("CPassword".equals(c.getName())) {
                onRegister_CPasswordAction(c, event);
                return;
            }
            if("Phone".equals(c.getName())) {
                onRegister_PhoneAction(c, event);
                return;
            }
            if("Register".equals(c.getName())) {
                onRegister_RegisterAction(c, event);
                return;
            }
            if("BtnHaveAccount".equals(c.getName())) {
                onRegister_BtnHaveAccountAction(c, event);
                return;
            }
        }
    }

      protected void onLogin_LogoAction(Component c, ActionEvent event) {
      }

      protected void onLogin_UsernameAction(Component c, ActionEvent event) {
      }

      protected void onLogin_PasswordAction(Component c, ActionEvent event) {
      }

      protected void onLogin_BtnLoginAction(Component c, ActionEvent event) {
      }

      protected void onLogin_BtnNoAccountAction(Component c, ActionEvent event) {
      }

      protected void onRegister_ProfilePicAction(Component c, ActionEvent event) {
      }

      protected void onRegister_UsernameAction(Component c, ActionEvent event) {
      }

      protected void onRegister_EmailAction(Component c, ActionEvent event) {
      }

      protected void onRegister_PasswordAction(Component c, ActionEvent event) {
      }

      protected void onRegister_CPasswordAction(Component c, ActionEvent event) {
      }

      protected void onRegister_PhoneAction(Component c, ActionEvent event) {
      }

      protected void onRegister_RegisterAction(Component c, ActionEvent event) {
      }

      protected void onRegister_BtnHaveAccountAction(Component c, ActionEvent event) {
      }

}
