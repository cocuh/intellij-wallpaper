package org.typowriter.intellij.plugins.wallpaper;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.util.Comparing;
import org.jetbrains.annotations.NotNull;

public class WallpaperApplicationComponent implements ApplicationComponent {
    private final static String EDITOR_PROPERTY_NAME = "idea.wallpaper.editor";
    private final static String IDE_PROPERTY_NAME = "idea.wallpaper.ide";

    public WallpaperApplicationComponent() {
    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
        if (System.getProperty(EDITOR_PROPERTY_NAME) != null & !Comparing.equal(System.getProperty(EDITOR_PROPERTY_NAME), "")) {
            notifyPropertyAlreadySet(EDITOR_PROPERTY_NAME);
        }
        if (System.getProperty(IDE_PROPERTY_NAME) != null & !Comparing.equal(System.getProperty(IDE_PROPERTY_NAME), "")) {
            notifyPropertyAlreadySet(IDE_PROPERTY_NAME);
        }

        refreshProperties();
    }

    private void notifyPropertyAlreadySet(String propertyName) {
        String content = "You have already set system property:\"" + propertyName + "\"\nThe property will be overwrote.";
        Notifications.Bus.notify(new Notification("Wallpaper Plugin", "Wallpaper Plugin", content, NotificationType.WARNING));
    }

    @Override
    public void disposeComponent() {
        clearProperties();
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "WallpaperApplicationComponent";
    }

    private static void clearProperties() {
        System.setProperty(IDE_PROPERTY_NAME, "");
        System.setProperty(EDITOR_PROPERTY_NAME, "");
    }

    static void refreshProperties() {
        System.setProperty(IDE_PROPERTY_NAME, WallpaperIdeSettings.getInstance().getPropertyString());
        System.setProperty(EDITOR_PROPERTY_NAME, WallpaperEditorSettings.getInstance().getPropertyString());
    }
}
