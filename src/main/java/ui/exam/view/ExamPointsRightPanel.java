package ui.exam.view;

import database.dao.TextsDao;
import ui.exam.view.balls.BallsPanel;
import ui.exam.view.balls.SpecialistBallsPanel;
import ui.exam.view.balls.StandardBallsPanel;
import util.Const;

import javax.swing.*;
import java.awt.*;


/**
 * Author: Daniel
 * Date: 03.11.13
 */
public class ExamPointsRightPanel extends JPanel {
    private BasicPartPanel standardPartPanel;
    private SpecjalistPartPanel specjalistPartPanel;
    private TimeAndBtnConfirmPanel timeAndBtnConfirmPanel;

    public ExamPointsRightPanel() {
        setUpPanel();
        initializeComponents();
    }

    private void setUpPanel() {
        BoxLayout layout =
                new BoxLayout(ExamPointsRightPanel.this, BoxLayout.Y_AXIS);
        setLayout(layout);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(Const.Colors.EXAM_BACKGROUND_COLOR);
    }

    private void initializeComponents() {
        standardPartPanel = new BasicPartPanel();
        specjalistPartPanel = new SpecjalistPartPanel();
        timeAndBtnConfirmPanel = new TimeAndBtnConfirmPanel();

        add(standardPartPanel);
        add(specjalistPartPanel);
        add(timeAndBtnConfirmPanel);
    }

    public class BasicPartPanel extends JPanel {
        private JLabel basicQuestionNumLbl;
        private StandardBallsPanel standardBallsPanel;

        public BasicPartPanel() {
            setLayout(new BoxLayout(BasicPartPanel.this, BoxLayout.Y_AXIS));
            setBackground(Const.Colors.EXAM_BACKGROUND_COLOR);

            JLabel basicPartLbl = new JLabel(TextsDao.getText("ExamPointRigthPanel.basicPartLbl"));
            basicPartLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            basicPartLbl.setFont(Const.Fonts.TEXTS_FONT);

            basicQuestionNumLbl = new JLabel(TextsDao.getText("ExamPointRigthPanel.basicPointsLbl"));
            basicQuestionNumLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            basicQuestionNumLbl.setFont(Const.Fonts.TEXTS_FONT);

            standardBallsPanel = new StandardBallsPanel();

            add(basicPartLbl);
            add(basicQuestionNumLbl);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(standardBallsPanel);
        }

        public void setQuestionNumber(int number) {
            basicQuestionNumLbl.setText("Pytanie numer: " + number + " / 20");
            standardBallsPanel.setQuestionNumber(number);
        }

        public StandardBallsPanel getStandardBallsPanel() {
            return standardBallsPanel;
        }
    }

    public class SpecjalistPartPanel extends JPanel {
        private JLabel specjalistQuestionNumLbl;
        private BallsPanel specialistBallsPanel;

        public SpecjalistPartPanel() {
            setLayout(new BoxLayout(SpecjalistPartPanel.this, BoxLayout.Y_AXIS));
            setBackground(Const.Colors.EXAM_BACKGROUND_COLOR);

            JLabel specjalistPartLbl = new JLabel(TextsDao.getText("ExamPointRigthPanel.specialistPartLbl"));
            specjalistPartLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            specjalistPartLbl.setFont(Const.Fonts.TEXTS_FONT);

            specjalistQuestionNumLbl = new JLabel(TextsDao.getText("ExamPointRigthPanel.specialistPointsLbl"));
            specjalistQuestionNumLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            specjalistQuestionNumLbl.setFont(Const.Fonts.TEXTS_FONT);

            specialistBallsPanel = new SpecialistBallsPanel();

            add(Box.createRigidArea(new Dimension(0, 10)));
            add(specjalistPartLbl);
            add(specjalistQuestionNumLbl);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(specialistBallsPanel);
        }

        public void setQuestionNumber(int number) {
            specjalistQuestionNumLbl.setText("Pytanie numer: " + number + " / 12");
            specialistBallsPanel.setQuestionNumber(number);
        }
    }

    public class TimeAndBtnConfirmPanel extends JPanel {
        private JLabel timerLbl;
        private JButton confirmBtn;
        private JLabel howManyPointsLbl;

        public TimeAndBtnConfirmPanel() {
            setLayout(new BoxLayout(TimeAndBtnConfirmPanel.this, BoxLayout.Y_AXIS));
            setBackground(Const.Colors.EXAM_BACKGROUND_COLOR);

            timerLbl = createTimerLbl();
            confirmBtn = createConfirmBtn();
            howManyPointsLbl = createHowManyPointsLbl();

            add(timerLbl);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(confirmBtn);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(howManyPointsLbl);
        }

        private JLabel createTimerLbl() {
            JLabel timerLbl = new JLabel();
            timerLbl.setHorizontalAlignment(SwingConstants.CENTER);
            timerLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            timerLbl.setFont(Const.Fonts.TIMER_FONT);
            timerLbl.setPreferredSize(Const.Dimensions.EXAM_TIME_LBL_SIZE);
            timerLbl.setMinimumSize(Const.Dimensions.EXAM_TIME_LBL_SIZE);
            timerLbl.setMaximumSize(Const.Dimensions.EXAM_TIME_LBL_SIZE);
            timerLbl.setForeground(Const.Colors.TIMER_FONT_COLOR);

            return timerLbl;
        }

        private JButton createConfirmBtn() {
            JButton button = new JButton(TextsDao.getText("ExamPointRigthPanel.btnConfirmLbl"));
            button.setFont(Const.Fonts.BTN_CONFIRM_FONT);
            button.setPreferredSize(Const.Dimensions.EXAM_CONFIRM_BTN_SIZE);
            button.setMinimumSize(Const.Dimensions.EXAM_CONFIRM_BTN_SIZE);
            button.setMaximumSize(Const.Dimensions.EXAM_CONFIRM_BTN_SIZE);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            return button;
        }

        private JLabel createHowManyPointsLbl() {
            JLabel howManyPointsLbl = new JLabel();
            howManyPointsLbl.setHorizontalAlignment(SwingConstants.CENTER);
            howManyPointsLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            howManyPointsLbl.setPreferredSize(Const.Dimensions.EXAM_CONFIRM_BTN_SIZE);
            howManyPointsLbl.setMinimumSize(Const.Dimensions.EXAM_CONFIRM_BTN_SIZE);
            howManyPointsLbl.setMaximumSize(Const.Dimensions.EXAM_CONFIRM_BTN_SIZE);
            howManyPointsLbl.setFont(Const.Fonts.TEXTS_FONT);
            howManyPointsLbl.setBorder(BorderFactory.createLineBorder(Const.Colors.HOW_MANY_POINTS_BORDER_COLOR));
            return howManyPointsLbl;
        }

        public JLabel getTimerLbl() {
            return timerLbl;
        }

        public JButton getConfirmBtn() {
            return confirmBtn;
        }

        public void setHowManyPointsText(String howManyPointsText) {
            howManyPointsLbl.setText(howManyPointsText);
        }
    }

    public BasicPartPanel getStandardPartPanel() {
        return standardPartPanel;
    }

    public SpecjalistPartPanel getSpecjalistPartPanel() {
        return specjalistPartPanel;
    }

    public TimeAndBtnConfirmPanel getTimeAndBtnConfirmPanel() {
        return timeAndBtnConfirmPanel;
    }

}