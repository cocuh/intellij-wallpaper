package org.typowriter.intellij.plugins.wallpaper;

public abstract class WallpaperBaseSettings implements IWallpaperSettings {

    WallpaperState myState;

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

