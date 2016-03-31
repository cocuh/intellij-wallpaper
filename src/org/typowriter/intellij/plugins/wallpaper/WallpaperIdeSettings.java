package org.typowriter.intellij.plugins.wallpaper;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.Nullable;

@State(name = "WallpaperIdeSettings", storages = @Storage("wallpaper_ide_settings.xml"))
public class WallpaperIdeSettings extends WallpaperBaseSettings implements PersistentStateComponent<WallpaperBaseSettings.State> {
    public WallpaperIdeSettings() {
        myState = new State();
    }

    @Nullable
    @Override
    public State getState() {
        return myState;
    }

    @Override
    public void loadState(State state) {
        myState = state;
    }
    
    public static WallpaperIdeSettings getInstance() {
        return ServiceManager.getService(WallpaperIdeSettings.class);
    }
}
