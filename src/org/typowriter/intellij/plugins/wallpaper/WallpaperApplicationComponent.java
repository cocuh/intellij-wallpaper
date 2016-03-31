package org.typowriter.intellij.plugins.wallpaper;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.NotNull;

public class WallpaperApplicationComponent implements ApplicationComponent {
    public WallpaperApplicationComponent() {
    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
        Notifications.Bus.notify(new Notification("", "", "youjo love", NotificationType.ERROR));
        System.setProperty("idea.wallpaper.editor","/tmp/illya.png,10");
        System.setProperty("idea.wallpaper.ide","/tmp/mashiro.gif,10");
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "WallpaperApplicationComponent";
    }
}
