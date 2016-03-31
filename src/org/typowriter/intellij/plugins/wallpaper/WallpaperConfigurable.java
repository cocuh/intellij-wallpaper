package org.typowriter.intellij.plugins.wallpaper;


import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.ui.components.JBTabbedPane;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import org.typowriter.intellij.plugins.wallpaper.ui.WallpaperSettingsPanel;

import javax.swing.*;

public class WallpaperConfigurable implements Configurable {

    private WallpaperSettingsPanel myIdeSettingPane;
    private WallpaperSettingsPanel myEditorSettingPane;

    @Nls
    @Override
    public String getDisplayName() {
        return "Wallpaper";
    }

    @Nullable
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
        JBTabbedPane tabbedPane = new JBTabbedPane();
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
    }

    @Override
    public void reset() {

    }

    @Override
    public void disposeUIResources() {

    }
}
