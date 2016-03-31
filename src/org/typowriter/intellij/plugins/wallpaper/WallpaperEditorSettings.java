package org.typowriter.intellij.plugins.wallpaper;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.Nullable;

@State(name = "WallpaperEditorSettings", storages = @Storage("wallpaper_editor_settings.xml"))
public class WallpaperEditorSettings extends WallpaperBaseSettings implements PersistentStateComponent<WallpaperBaseSettings.State> {
    public WallpaperEditorSettings() {
        myState = new State();
    }

    @Nullable
    @Override
    public WallpaperBaseSettings.State getState() {
        return myState;
    }

    @Override
    public void loadState(WallpaperBaseSettings.State state) {
        myState = state;
    }

    public static WallpaperIdeSettings getInstance() {
        return ServiceManager.getService(WallpaperIdeSettings.class);
    }
}
