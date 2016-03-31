package org.typowriter.intellij.plugins.wallpaper;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.Nullable;

@State(name = "WallpaperEditorSettings", storages = @Storage("wallpaper_editor_settings.xml"))
public class WallpaperEditorSettings extends WallpaperBaseSettings implements PersistentStateComponent<WallpaperState> {
    WallpaperEditorSettings() {
        myState = new WallpaperState();
    }

    @Nullable
    @Override
    public WallpaperState getState() {
        return myState;
    }

    @Override
    public void loadState(WallpaperState state) {
        myState = state;
    }

    static WallpaperEditorSettings getInstance() {
        return ServiceManager.getService(WallpaperEditorSettings.class);
    }
}
