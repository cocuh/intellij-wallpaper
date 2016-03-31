package org.typowriter.intellij.plugins.wallpaper;

import org.jetbrains.annotations.NotNull;

public abstract class WallpaperBaseSettings {

    State myState;

    public class State {
        @NotNull
        public String filePath = "";
        @NotNull
        public String url = "";
        public boolean urlSelected = false;
        public int opacity = 10;
        @NotNull
        public String mode = "";
        // todo: refactoring, use enum. enum is available in PersistentState?
        // I use String as mode, because i don't want to think migration of PersistentState/
    }

    public final String getFilePath() {
        return myState.filePath;
    }

    public final void setFilePath(final String filePath) {
        myState.filePath = filePath;
    }

    public final String getUrl() {
        return myState.url;
    }

    public final void setUrl(final String url) {
        myState.url = url;
    }

    public final boolean isUrlSelected() {
        return myState.urlSelected;
    }

    public final void setUrlSelected(boolean urlSelected) {
        myState.urlSelected = urlSelected;
    }

    public final String getMode() {
        return myState.mode;
    }

    public final void setMode(final String mode) {
        myState.mode = mode;
    }

    public final int getOpacity() {
        return myState.opacity;
    }

    public final void setOpacity(final int opacity) {
        myState.opacity = opacity;
    }
}

