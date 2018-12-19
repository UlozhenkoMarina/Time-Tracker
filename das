[33mcommit 730328d667d1b158931c929fe8545f60844ce96e[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m)[m
Author: vonKleve <alas1633@gmail.com>
Date:   Tue Dec 18 02:21:36 2018 +0200

    Reset this

[1mdiff --git a/.gitignore b/.gitignore[m
[1mnew file mode 100644[m
[1mindex 0000000..a1c2a23[m
[1m--- /dev/null[m
[1m+++ b/.gitignore[m
[36m@@ -0,0 +1,23 @@[m
[32m+[m[32m# Compiled class file[m
[32m+[m[32m*.class[m
[32m+[m
[32m+[m[32m# Log file[m
[32m+[m[32m*.log[m
[32m+[m
[32m+[m[32m# BlueJ files[m
[32m+[m[32m*.ctxt[m
[32m+[m
[32m+[m[32m# Mobile Tools for Java (J2ME)[m
[32m+[m[32m.mtj.tmp/[m
[32m+[m
[32m+[m[32m# Package Files #[m
[32m+[m[32m*.jar[m
[32m+[m[32m*.war[m
[32m+[m[32m*.nar[m
[32m+[m[32m*.ear[m
[32m+[m[32m*.zip[m
[32m+[m[32m*.tar.gz[m
[32m+[m[32m*.rar[m
[32m+[m
[32m+[m[32m# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml[m
[32m+[m[32mhs_err_pid*[m
[1mdiff --git a/Time-Tracker b/Time-Tracker[m
[1mnew file mode 160000[m
[1mindex 0000000..6b833a9[m
[1m--- /dev/null[m
[1m+++ b/Time-Tracker[m
[36m@@ -0,0 +1 @@[m
[32m+[m[32mSubproject commit 6b833a9c3a433874a1ff5c5c1d2ae19c754b2f16[m
[1mdiff --git a/UserController.java b/UserController.java[m
[1mnew file mode 100644[m
[1mindex 0000000..c377989[m
[1m--- /dev/null[m
[1m+++ b/UserController.java[m
[36m@@ -0,0 +1,133 @@[m
[32m+[m[32mpackage com.timetracker.timet_racker_web_app.controller;[m
[32m+[m
[32m+[m[32mimport com.timetracker.timet_racker_web_app.dao.repository.UserReposirory;[m
[32m+[m[32mimport com.timetracker.timet_racker_web_app.dao.service.UserService;[m
[32m+[m[32mimport com.timetracker.timet_racker_web_app.form.LoginForm;[m
[32m+[m[32mimport com.timetracker.timet_racker_web_app.form.RegisterForm;[m
[32m+[m[32mimport com.timetracker.timet_racker_web_app.model.User;[m
[32m+[m[32mimport org.springframework.beans.factory.annotation.Autowired;[m
[32m+[m[32mimport org.springframework.stereotype.Controller;[m
[32m+[m[32mimport org.springframework.ui.Model;[m
[32m+[m[32mimport org.springframework.web.bind.annotation.RequestMapping;[m
[32m+[m[32mimport org.springframework.web.bind.annotation.RequestMethod;[m
[32m+[m
[32m+[m
[32m+[m[32m@Controller[m
[32m+[m[32mpublic class UserController {[m
[32m+[m
[32m+[m[32m    User user=null;[m
[32m+[m
[32m+[m[32m    @Autowired[m
[32m+[m[32m    private UserService userService;[m
[32m+[m
[32m+[m[32m    @RequestMapping(value = "/", method = RequestMethod.GET)[m
[32m+[m[32m    public String viewLoginPage(Model model) {[m
[32m+[m
[32m+[m[32m        LoginForm form = new LoginForm();[m
[32m+[m[32m        model.addAttribute("loginForm", form);[m
[32m+[m[32m        return "loginPage";[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)[m
[32m+[m[32m    public String login(Model model, LoginForm form) {[m
[32m+[m
[32m+[m[32m        System.out.println(form.getEmail());[m
[32m+[m[32m        User user = userService.getUser(form.getEmail(), form.getPassword());[m
[32m+[m[32m        if (user == null) {[m
[32m+[m[32m            return "loginPage";[m
[32m+[m[32m        } else {[m
[32m+[m[32m            model.addAttribute("User", user);[m
[32m+[m[32m        }[m
[32m+[m[32m        return "success";[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @RequestMapping(value = { "/logout" }, method = RequestMethod.POST)[m
[32m+[m[32m    public String logout(Model model, LoginForm form) {[m
[32m+[m
[32m+[m[32m        System.out.println(form.getEmail());[m
[32m+[m[32m        User user = userService.getUser(form.getEmail(), form.getPassword());[m
[32m+[m[32m        user=null;[m
[32m+[m[32m        return "loginPage";[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @RequestMapping(value = "/register", method = RequestMethod.GET)[m
[32m+[m[32m    public String viewRegisterPage(Model model) {[m
[32m+[m
[32m+[m[32m        RegisterForm form = new RegisterForm();[m
[32m+[m[32m        model.addAttribute("registerForm", form);[m
[32m+[m[32m        return "registerPage";[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    @RequestMapping(value = { "/signup"}, method = RequestMethod.POST)[m
[32m+[m[32m    public String register(Model model, RegisterForm form) {[m
[32m+[m
[32m+[m[32m        System.out.println(form.getEmail());[m
[32m+[m[32m        //User user = new User();[m
[32m+[m[32m        user=new User();[m
[32m+[m[32m        user.setPassword(form.getPassword());[m
[32m+[m[32m        user.setMobileNumber(form.getPhone());[m
[32m+[m[32m        user.setEmail(form.getEmail());[m
[32m+[m[32m        user.setName(form.getName());[m
[32m+[m[32m        user.setSurname(form.getSurname());[m
[32m+[m[32m        user.setUsername(form.getUsername());[m
[32m+[m[32m        user.setCountry(form.getCountry());[m
[32m+[m[32m        user.setCity(form.getCity());[m
[32m+[m[32m        user = userService.addUser(user);[m
[32m+[m[32m        if (user == null) {[m
[32m+[m[32m            return "registerPage";[m
[32m+[m[32m        } else {[m
[32m+[m[32m            model.addAttribute("User", user);[m
[32m+[m[32m        }[m
[32m+[m[32m        return "success";[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m
[32m+[m[32m    @RequestMapping(value = { "/userCabinetModify"}, method = RequestMethod.POST)[m
[32m+[m[32m    public String userCabinetModify(Model model, RegisterForm form) {[m
[32m+[m
[32m+[m[32m        System.out.println(form.getEmail());[m
[32m+[m[32m        //User user = new User();[m
[32m+[m[32m        //user=new User();[m
[32m+[m[32m        user.setPassword(form.getPassword());[m
[32m+[m[32m        user.setMobileNumber(form.getPhone());[m
[32m+[m[32m        user.setEmail(form.getEmail());[m
[32m+[m[32m        user.setName(form.getName());[m
[32m+[m[32m        user.setSurname(form.getSurname());[m
[32m+[m[32m        user.setUsername(form.getUsername());[m
[32m+[m[32m        user.setCountry(form.getCountry());[m
[32m+[m[32m        user.setCity(form.getCity());[m
[32m+[m[32m        user = userService.addUser(user);[m
[32m+[m[32m        if (user == null) {[m
[32m+[m[32m            return "registerPage";[m
[32m+[m[32m        } else {[m
[32m+[m[32m            user=userService.updateUser(user);[m
[32m+[m[32m            model.addAttribute("User", user);[m
[32m+[m[32m        }[m
[32m+[m[32m        return "userCabinet";[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m
[32m+[m
[32m+[m[32m@RequestMapping(value = { "/userCabinet"}, method = RequestMethod.POST)[m
[32m+[m[32mpublic String userCabinet(Model model, RegisterForm form) {[m
[32m+[m
[32m+[m[32m        System.out.println(form.getEmail());[m
[32m+[m[32m        //User user = new User();[m
[32m+[m[32m        //user=new User();[m
[32m+[m[32m        user.getPassword();[m
[32m+[m[32m        user.getMobileNumber();[m
[32m+[m[32m        user.getEmail();[m
[32m+[m[32m        user.getName();[m
[32m+[m[32m        user.getSurname();[m
[32m+[m[32m        user.getUsername();[m
[32m+[m[32m        user.getCountry();[m
[32m+[m[32m        user.getCity();[m
[32m+[m[32m        user = userService.addUser(user);[m
[32m+[m[32m        if (user == null) {[m
[32m+[m[32m        return "registerPage";[m
[32m+[m[32m        } else {[m
[32m+[m[32m        model.addAttribute("User", user);[m
[32m+[m[32m        }[m
[32m+[m[32m        return "userCabinet";[m
[32m+[m[32m        }[m
[32m+[m[32m        }[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/.name b/time_tracker_web_app/.idea/.name[m
[1mnew file mode 100644[m
[1mindex 0000000..fe2f710[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/.name[m
[36m@@ -0,0 +1 @@[m
[32m+[m[32mtimet_racker_web_app[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/compiler.xml b/time_tracker_web_app/.idea/compiler.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..8f8f7d4[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/compiler.xml[m
[36m@@ -0,0 +1,21 @@[m
[32m+[m[32m<?xml version="1.0" encoding="UTF-8"?>[m
[32m+[m[32m<project version="4">[m
[32m+[m[32m  <component name="CompilerConfiguration">[m
[32m+[m[32m    <annotationProcessing>[m
[32m+[m[32m      <profile name="Maven default annotation processors profile" enabled="true">[m
[32m+[m[32m        <sourceOutputDir name="target/generated-sources/annotations" />[m
[32m+[m[32m        <sourceTestOutputDir name="target/generated-test-sources/test-annotations" />[m
[32m+[m[32m        <outputRelativeToContentRoot value="true" />[m
[32m+[m[32m        <module name="timet_racker_web_app" />[m
[32m+[m[32m      </profile>[m
[32m+[m[32m    </annotationProcessing>[m
[32m+[m[32m    <bytecodeTargetLevel>[m
[32m+[m[32m      <module name="timet_racker_web_app" target="1.8" />[m
[32m+[m[32m    </bytecodeTargetLevel>[m
[32m+[m[32m  </component>[m
[32m+[m[32m  <component name="JavacSettings">[m
[32m+[m[32m    <option name="ADDITIONAL_OPTIONS_OVERRIDE">[m
[32m+[m[32m      <module name="timet_racker_web_app" options="-parameters" />[m
[32m+[m[32m    </option>[m
[32m+[m[32m  </component>[m
[32m+[m[32m</project>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/encodings.xml b/time_tracker_web_app/.idea/encodings.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..e79da7e[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/encodings.xml[m
[36m@@ -0,0 +1,6 @@[m
[32m+[m[32m<?xml version="1.0" encoding="UTF-8"?>[m
[32m+[m[32m<project version="4">[m
[32m+[m[32m  <component name="Encoding" addBOMForNewFiles="with NO BOM">[m
[32m+[m[32m    <file url="file://$PROJECT_DIR$" charset="UTF-8" />[m
[32m+[m[32m  </component>[m
[32m+[m[32m</project>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__antlr_antlr_2_7_7.xml b/time_tracker_web_app/.idea/libraries/Maven__antlr_antlr_2_7_7.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..b8d93d8[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__antlr_antlr_2_7_7.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: antlr:antlr:2.7.7">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/antlr/antlr/2.7.7/antlr-2.7.7.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/antlr/antlr/2.7.7/antlr-2.7.7-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/antlr/antlr/2.7.7/antlr-2.7.7-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__ch_qos_logback_logback_classic_1_2_3.xml b/time_tracker_web_app/.idea/libraries/Maven__ch_qos_logback_logback_classic_1_2_3.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..6fec8f4[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__ch_qos_logback_logback_classic_1_2_3.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: ch.qos.logback:logback-classic:1.2.3">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__ch_qos_logback_logback_core_1_2_3.xml b/time_tracker_web_app/.idea/libraries/Maven__ch_qos_logback_logback_core_1_2_3.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..9eb8596[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__ch_qos_logback_logback_core_1_2_3.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: ch.qos.logback:logback-core:1.2.3">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_classmate_1_4_0.xml b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_classmate_1_4_0.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..bbd3a88[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_classmate_1_4_0.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: com.fasterxml:classmate:1.4.0">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/classmate/1.4.0/classmate-1.4.0.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/classmate/1.4.0/classmate-1.4.0-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/classmate/1.4.0/classmate-1.4.0-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_core_jackson_annotations_2_9_0.xml b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_core_jackson_annotations_2_9_0.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..06441f4[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_core_jackson_annotations_2_9_0.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: com.fasterxml.jackson.core:jackson-annotations:2.9.0">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/core/jackson-annotations/2.9.0/jackson-annotations-2.9.0.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/core/jackson-annotations/2.9.0/jackson-annotations-2.9.0-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/core/jackson-annotations/2.9.0/jackson-annotations-2.9.0-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_core_jackson_core_2_9_7.xml b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_core_jackson_core_2_9_7.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..02897be[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_core_jackson_core_2_9_7.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: com.fasterxml.jackson.core:jackson-core:2.9.7">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/core/jackson-core/2.9.7/jackson-core-2.9.7.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/core/jackson-core/2.9.7/jackson-core-2.9.7-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/core/jackson-core/2.9.7/jackson-core-2.9.7-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_core_jackson_databind_2_9_7.xml b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_core_jackson_databind_2_9_7.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..11ddfba[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_core_jackson_databind_2_9_7.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: com.fasterxml.jackson.core:jackson-databind:2.9.7">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/core/jackson-databind/2.9.7/jackson-databind-2.9.7.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/core/jackson-databind/2.9.7/jackson-databind-2.9.7-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/core/jackson-databind/2.9.7/jackson-databind-2.9.7-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_datatype_jackson_datatype_jdk8_2_9_7.xml b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_datatype_jackson_datatype_jdk8_2_9_7.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..a5beee8[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_datatype_jackson_datatype_jdk8_2_9_7.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.9.7">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.9.7/jackson-datatype-jdk8-2.9.7.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.9.7/jackson-datatype-jdk8-2.9.7-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.9.7/jackson-datatype-jdk8-2.9.7-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_datatype_jackson_datatype_jsr310_2_9_7.xml b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_datatype_jackson_datatype_jsr310_2_9_7.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..9bcce3b[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_datatype_jackson_datatype_jsr310_2_9_7.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.9.7">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.9.7/jackson-datatype-jsr310-2.9.7.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.9.7/jackson-datatype-jsr310-2.9.7-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.9.7/jackson-datatype-jsr310-2.9.7-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_module_jackson_module_parameter_names_2_9_7.xml b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_module_jackson_module_parameter_names_2_9_7.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..b9cc6e2[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__com_fasterxml_jackson_module_jackson_module_parameter_names_2_9_7.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: com.fasterxml.jackson.module:jackson-module-parameter-names:2.9.7">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/module/jackson-module-parameter-names/2.9.7/jackson-module-parameter-names-2.9.7.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/module/jackson-module-parameter-names/2.9.7/jackson-module-parameter-names-2.9.7-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/fasterxml/jackson/module/jackson-module-parameter-names/2.9.7/jackson-module-parameter-names-2.9.7-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__com_jayway_jsonpath_json_path_2_4_0.xml b/time_tracker_web_app/.idea/libraries/Maven__com_jayway_jsonpath_json_path_2_4_0.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..f19f6eb[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__com_jayway_jsonpath_json_path_2_4_0.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: com.jayway.jsonpath:json-path:2.4.0">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/jayway/jsonpath/json-path/2.4.0/json-path-2.4.0.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/jayway/jsonpath/json-path/2.4.0/json-path-2.4.0-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/jayway/jsonpath/json-path/2.4.0/json-path-2.4.0-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__com_vaadin_external_google_android_json_0_0_20131108_vaadin1.xml b/time_tracker_web_app/.idea/libraries/Maven__com_vaadin_external_google_android_json_0_0_20131108_vaadin1.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..b8581a6[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__com_vaadin_external_google_android_json_0_0_20131108_vaadin1.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: com.vaadin.external.google:android-json:0.0.20131108.vaadin1">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/vaadin/external/google/android-json/0.0.20131108.vaadin1/android-json-0.0.20131108.vaadin1.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/vaadin/external/google/android-json/0.0.20131108.vaadin1/android-json-0.0.20131108.vaadin1-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/vaadin/external/google/android-json/0.0.20131108.vaadin1/android-json-0.0.20131108.vaadin1-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__com_zaxxer_HikariCP_3_2_0.xml b/time_tracker_web_app/.idea/libraries/Maven__com_zaxxer_HikariCP_3_2_0.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..8f760a2[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__com_zaxxer_HikariCP_3_2_0.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: com.zaxxer:HikariCP:3.2.0">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/zaxxer/HikariCP/3.2.0/HikariCP-3.2.0.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/zaxxer/HikariCP/3.2.0/HikariCP-3.2.0-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/com/zaxxer/HikariCP/3.2.0/HikariCP-3.2.0-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__javax_activation_javax_activation_api_1_2_0.xml b/time_tracker_web_app/.idea/libraries/Maven__javax_activation_javax_activation_api_1_2_0.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..ff49512[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__javax_activation_javax_activation_api_1_2_0.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: javax.activation:javax.activation-api:1.2.0">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__javax_annotation_javax_annotation_api_1_3_2.xml b/time_tracker_web_app/.idea/libraries/Maven__javax_annotation_javax_annotation_api_1_3_2.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..e74f3ab[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__javax_annotation_javax_annotation_api_1_3_2.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: javax.annotation:javax.annotation-api:1.3.2">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__javax_persistence_javax_persistence_api_2_2.xml b/time_tracker_web_app/.idea/libraries/Maven__javax_persistence_javax_persistence_api_2_2.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..b7d39c6[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__javax_persistence_javax_persistence_api_2_2.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: javax.persistence:javax.persistence-api:2.2">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/persistence/javax.persistence-api/2.2/javax.persistence-api-2.2.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/persistence/javax.persistence-api/2.2/javax.persistence-api-2.2-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/persistence/javax.persistence-api/2.2/javax.persistence-api-2.2-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__javax_servlet_jstl_1_2.xml b/time_tracker_web_app/.idea/libraries/Maven__javax_servlet_jstl_1_2.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..f329893[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__javax_servlet_jstl_1_2.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: javax.servlet:jstl:1.2">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/servlet/jstl/1.2/jstl-1.2.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/servlet/jstl/1.2/jstl-1.2-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/servlet/jstl/1.2/jstl-1.2-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tracker_web_app/.idea/libraries/Maven__javax_transaction_javax_transaction_api_1_3.xml b/time_tracker_web_app/.idea/libraries/Maven__javax_transaction_javax_transaction_api_1_3.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..8f5f3c6[m
[1m--- /dev/null[m
[1m+++ b/time_tracker_web_app/.idea/libraries/Maven__javax_transaction_javax_transaction_api_1_3.xml[m
[36m@@ -0,0 +1,13 @@[m
[32m+[m[32m<component name="libraryTable">[m
[32m+[m[32m  <library name="Maven: javax.transaction:javax.transaction-api:1.3">[m
[32m+[m[32m    <CLASSES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/transaction/javax.transaction-api/1.3/javax.transaction-api-1.3.jar!/" />[m
[32m+[m[32m    </CLASSES>[m
[32m+[m[32m    <JAVADOC>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/transaction/javax.transaction-api/1.3/javax.transaction-api-1.3-javadoc.jar!/" />[m
[32m+[m[32m    </JAVADOC>[m
[32m+[m[32m    <SOURCES>[m
[32m+[m[32m      <root url="jar://$MAVEN_REPOSITORY$/javax/transaction/javax.transaction-api/1.3/javax.transaction-api-1.3-sources.jar!/" />[m
[32m+[m[32m    </SOURCES>[m
[32m+[m[32m  </library>[m
[32m+[m[32m</component>[m
\ No newline at end of file[m
[1mdiff --git a/time_tra