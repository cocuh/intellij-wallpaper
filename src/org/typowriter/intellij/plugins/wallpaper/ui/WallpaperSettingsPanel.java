package org.typowriter.intellij.plugins.wallpaper.ui;

import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.util.Comparing;
import org.jetbrains.annotations.NotNull;
import org.typowriter.intellij.plugins.wallpaper.IWallpaperSettings;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class WallpaperSettingsPanel {
    private JRadioButton fileRadioButton;
    private JRadioButton URLRadioButton;
    private JTextField urlField;
    private JSlider slider1;
    private JRadioButton scaleRadioButton;
    private JRadioButton tileRadioButton;
    private JRadioButton centerRadioButton;
    private JRadioButton topLeftRadioButton;
    private JRadioButton bottomCenterRadioButton;
    private JRadioButton topCenterRadioButton;
    private JRadioButton topRightRadioButton;
    private JRadioButton bottomRightRadioButton;
    private JRadioButton bottomLeftRadioButton;
    private JRadioButton bgCenterRadioButton;
    private JPanel myPane;
    private TextFieldWithBrowseButton filePathField;
    private final IWallpaperSettings mySettings;

    private List<JRadioButton> radioButtonList = Arrays.asList(
            scaleRadioButton,
            tileRadioButton,
            centerRadioButton,
            topLeftRadioButton,
            bottomCenterRadioButton,
            topCenterRadioButton,
            topRightRadioButton,
            bottomRightRadioButton,
            bottomLeftRadioButton,
            bgCenterRadioButton
    );

    public WallpaperSettingsPanel(IWallpaperSettings settings) {
        mySettings = settings;
    }

    @NotNull
    public JComponent getPanel() {
        return myPane;
    }

    @NotNull
    public String getUrl() {
        return urlField.getText();
    }

    public void setUrl(@NotNull String url) {
        urlField.setText(url);
    }

    @NotNull
    public String getFilePath() {
        return filePathField.getText();
    }

    public void setFilePath(@NotNull String path) {
        filePathField.setText(path);
    }


    public boolean isUrlSelected() {
        return URLRadioButton.isSelected();
    }

    public void setUrlSelected(boolean value) {
        fileRadioButton.setSelected(!value);
        URLRadioButton.setSelected(value);
    }

    public int getOpacity() {
        return slider1.getValue();
    }

    public void setOpacity(int value) {
        slider1.setValue(value);
    }

    @NotNull
    public String getMode() {
        String DEFAULT_MODE = "scale";
        for (JRadioButton radioButton : radioButtonList) {
            if (radioButton.isSelected()) {
                return radioButton.getText();
            }
        }
        return DEFAULT_MODE;
    }

    public void setMode(@NotNull String mode) {
        for (JRadioButton radioButton : radioButtonList) {
            radioButton.setSelected(Comparing.equal(radioButton.getText(), mode));
        }
    }

    public boolean isModified() {
        return !Comparing.equal(mySettings.getFilePath(), getFilePath())
                | !Comparing.equal(mySettings.getUrl(), getUrl())
                | !Comparing.equal(mySettings.isUrlSelected(), isUrlSelected())
                | !Comparing.equal(mySettings.getMode(), getMode())
                | !Comparing.equal(mySettings.getOpacity(), getOpacity());
    }

    public void apply() {
        mySettings.setFilePath(getFilePath());
        mySettings.setUrl(getUrl());
        mySettings.setUrlSelected(isUrlSelected());
        mySettings.setOpacity(getOpacity());
        mySettings.setMode(getMode());
    }

    public void reset() {
        setFilePath(mySettings.getFilePath());
        setUrl(mySettings.getUrl());
        setUrlSelected(mySettings.isUrlSelected());
        setOpacity(mySettings.getOpacity());
        setMode(mySettings.getMode());
    }
}
