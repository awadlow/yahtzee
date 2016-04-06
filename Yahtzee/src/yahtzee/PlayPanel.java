package yahtzee;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

public class PlayPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlayPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblYahtzee = new JLabel("Yahtzee!");
		GridBagConstraints gbc_lblYahtzee = new GridBagConstraints();
		gbc_lblYahtzee.gridx = 7;
		gbc_lblYahtzee.gridy = 1;
		add(lblYahtzee, gbc_lblYahtzee);

	}

}
