package ui.exam.view;

import database.dao.TextsDao;
import media.images.ImageUtils;
import media.videos.VideoCodec;
import media.videos.VideoPanel;
import util.Const;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

/**
 * Author: Daniel
 * Date: 03.11.13
 */
public class ExamQuestionsLeftPanel extends JPanel {
    private JPanel imagePanel;
    private JPanel abcBtnPanel;
    private JPanel yesNoBtnPanel;

    private JLabel imageLabel;
    private JTextArea questionTextArea;

    private JButton yesBtn;
    private JButton noBtn;
    private JButton btnA;
    private JButton btnB;
    private JButton btnC;

    private Border emptyBorder;

    public ExamQuestionsLeftPanel() {
        setUpPanel();
        initializeComponents();
    }

    private void setUpPanel() {
        emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Const.Colors.EXAM_BACKGROUND_COLOR);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(emptyBorder);
    }

    private void initializeComponents() {
        imagePanel = getImagePanel();
        JPanel questionPanel = getQuestionPanel();
        abcBtnPanel = getABCBtnPanel();
        yesNoBtnPanel = getYesNoBtnPanel();

        add(imagePanel);
        add(questionPanel);
        add(yesNoBtnPanel);
    }

    public JPanel getImagePanel() {
        JPanel imagePanel = new JPanel();

        imagePanel.setBackground(Const.Colors.EXAM_BACKGROUND_COLOR);

        String noPhotoFileName = TextsDao.getFileName("img.no_photo");
        ImageIcon image = ImageUtils.getProgramImage(noPhotoFileName);

        imageLabel = new JLabel("", image, SwingConstants.CENTER);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        imagePanel.add(imageLabel);
        return imagePanel;
    }

    public JPanel getQuestionPanel() {
        JPanel questionPanel = new JPanel();
        questionPanel.setBackground(Const.Colors.EXAM_BACKGROUND_COLOR);

        questionTextArea = getQuestionTextArea();

        questionPanel.add(questionTextArea);
        return questionPanel;
    }

    private JTextArea getQuestionTextArea() {
        JTextArea questionTextArea = new JTextArea(3, 49);
        questionTextArea.setBorder(emptyBorder);
        questionTextArea.setFont(Const.Fonts.TEXTS_FONT);
        questionTextArea.setBackground(Const.Colors.EXAM_BACKGROUND_COLOR);
        questionTextArea.setLineWrap(true);
        questionTextArea.setWrapStyleWord(true);
        questionTextArea.setEditable(false);
        return questionTextArea;
    }

    public JPanel getYesNoBtnPanel() {
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBackground(Const.Colors.EXAM_BACKGROUND_COLOR);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        noBtn = createYesNoBtn(TextsDao.getText("noButtonLbl"));
        yesBtn = createYesNoBtn(TextsDao.getText("yesButtonLbl"));

        buttonPanel.add(noBtn);
        buttonPanel.add(yesBtn);

        return buttonPanel;
    }

    private JPanel getABCBtnPanel() {
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBackground(Const.Colors.EXAM_BACKGROUND_COLOR);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        btnA = createABCBtn();
        btnB = createABCBtn();
        btnC = createABCBtn();

        buttonPanel.add(btnA);
        buttonPanel.add(btnB);
        buttonPanel.add(btnC);

        return buttonPanel;
    }

    private JButton createYesNoBtn(String label) {
        JButton button = new JButton(label);
        button.setFont(Const.Fonts.BTNS_YES_NO_FONT);
        button.setPreferredSize(Const.Dimensions.EXAM_YES_NO_BTN_SIZE);
        button.setMinimumSize(Const.Dimensions.EXAM_YES_NO_BTN_SIZE);
        button.setMaximumSize(Const.Dimensions.EXAM_YES_NO_BTN_SIZE);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFocusable(false);
        return button;
    }

    private JButton createABCBtn() {
        JButton button = new JButton();
        button.setFont(Const.Fonts.BTNS_ABC_FONT);
        button.setPreferredSize(Const.Dimensions.ABC_BTNS_SIZE);
        button.setMinimumSize(Const.Dimensions.ABC_BTNS_SIZE);
        button.setMaximumSize(Const.Dimensions.ABC_BTNS_SIZE);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFocusable(false);
        return button;
    }

    public void setQestion(String qestion) {
        questionTextArea.setText(qestion);
    }

    public void setBtnABCTexts(String btnAText, String btnBText, String btnCText) {
        this.btnA.setText(btnAText);
        this.btnB.setText(btnBText);
        this.btnC.setText(btnCText);
    }

    public void changePanelFromStandarToSpecial() {
        remove(yesNoBtnPanel);
        add(abcBtnPanel);
    }

    public void showWaitImageImage() {
        imagePanel.removeAll();
        String imgFileName = TextsDao.getFileName("img.wait_photo");
        ImageIcon image = ImageUtils.getProgramImage(imgFileName);
        imagePanel.remove(imageLabel);
        imageLabel = new JLabel("", image, JLabel.CENTER);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        imagePanel.add(imageLabel);
    }

    public void showWaitVideoImage() {
        imagePanel.removeAll();
        String imgFileName = TextsDao.getFileName("img.wait_video");
        ImageIcon image = ImageUtils.getProgramImage(imgFileName);
        imageLabel = new JLabel("", image, JLabel.CENTER);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        imagePanel.add(imageLabel);
    }

    public void setImageName(String imageName) {
        try {
            ImageIcon image = ImageUtils.getQuestionImage(imageName);
            imagePanel.removeAll();
            imageLabel = new JLabel("", image, JLabel.CENTER);
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            imagePanel.add(imageLabel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e, "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setVideoName(final String videoName) {
        imagePanel.removeAll();
        final VideoPanel videoPanel = new VideoPanel();
        videoPanel.setPreferredSize(Const.Dimensions.VIDEO_SIZE);
        videoPanel.setMinimumSize(Const.Dimensions.VIDEO_SIZE);
        videoPanel.setMaximumSize(Const.Dimensions.VIDEO_SIZE);
        imagePanel.add(videoPanel);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                VideoCodec videoCodec =
                        new VideoCodec(videoPanel, videoName);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void enableAllBtns() {
        yesBtn.setEnabled(true);
        noBtn.setEnabled(true);
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
    }

    public void disableAllBtns() {
        yesBtn.setEnabled(false);
        noBtn.setEnabled(false);
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
    }

    public JButton getYesBtn() {
        return yesBtn;
    }

    public JButton getNoBtn() {
        return noBtn;
    }

    public JButton getBtnA() {
        return btnA;
    }

    public JButton getBtnB() {
        return btnB;
    }

    public JButton getBtnC() {
        return btnC;
    }
}
