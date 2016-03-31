package org.typowriter.intellij.plugins.wallpaper;


import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.ui.components.JBTabbedPane;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.typowriter.intellij.plugins.wallpaper.ui.WallpaperSettingsPanel;

import javax.swing.*;

public class WallpaperConfigurable implements SearchableConfigurable {

    private WallpaperSettingsPanel myIdeSettingPane;
    private WallpaperSettingsPanel myEditorSettingPane;
    private JBTabbedPane tabbedPane;

    @Nls
    @Override
    public String getDisplayName() {
        return "Wallpaper";
    }

    @NotNull
    @Override
    public String getHelpTopic() {
        return "settings.wallpaper";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (myIdeSettingPane == null) {
            myIdeSettingPane = new WallpaperSettingsPanel(WallpaperIdeSettings.getInstance());
        }
        if (myEditorSettingPane == null) {
            myEditorSettingPane = new WallpaperSettingsPanel(WallpaperEditorSettings.getInstance());
        }
        tabbedPane = new JBTabbedPane();
        tabbedPane.add(myIdeSettingPane.getPanel(), "IDE");
        tabbedPane.add(myEditorSettingPane.getPanel(), "Editor");
        return tabbedPane;
    }

    @Override
    public boolean isModified() {
        return myIdeSettingPane.isModified() || myEditorSettingPane.isModified();
    }

    @Override
    public void apply() throws ConfigurationException {
        myIdeSettingPane.apply();
        myEditorSettingPane.apply();
        Notifications.Bus.notify(new Notification("", "", "pane:" + myIdeSettingPane.getFilePath(), NotificationType.ERROR));
        Notifications.Bus.notify(new Notification("", "", "settings:" + WallpaperIdeSettings.getInstance().getFilePath(), NotificationType.ERROR));
    }

    @Override
    public void reset() {
        myIdeSettingPane.reset();
        myEditorSettingPane.reset();
    }

    @Override
    public void disposeUIResources() {
        tabbedPane = null;
        myIdeSettingPane = null;
        myEditorSettingPane = null;
    }

    @NotNull
    @Override
    public String getId() {
        return getHelpTopic();
    }

    @Nullable
    @Override
    public Runnable enableSearch(String s) {
        return null;
    }
}
