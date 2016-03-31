package org.typowriter.intellij.plugins.wallpaper;

import org.jetbrains.annotations.NotNull;

public class WallpaperState {
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
