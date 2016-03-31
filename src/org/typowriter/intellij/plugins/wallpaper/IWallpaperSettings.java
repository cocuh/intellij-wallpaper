package org.typowriter.intellij.plugins.wallpaper;

import org.jetbrains.annotations.NotNull;

public interface IWallpaperSettings {
    @NotNull
    String getFilePath();

    void setFilePath(final @NotNull String filePath);

    @NotNull
    String getUrl();

    void setUrl(final @NotNull String url);

    boolean isUrlSelected();

    void setUrlSelected(boolean urlSelected);

    @NotNull
    String getMode();

    void setMode(final @NotNull String mode);

    int getOpacity();

    void setOpacity(final int opacity);
}
