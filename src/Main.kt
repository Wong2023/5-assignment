import java.awt.*
import javax.swing.*

fun main() {
    SwingUtilities.invokeLater {
        createAndShowUI()
    }
}

fun createAndShowUI() {
    val frame = JFrame("Counter App")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    val mainPanel = JPanel()
    mainPanel.layout = BoxLayout(mainPanel, BoxLayout.Y_AXIS)
    mainPanel.border = BorderFactory.createEmptyBorder(16, 16, 16, 16)

    mainPanel.add(createCounterRow("Counter 1"))
    mainPanel.add(Box.createVerticalStrut(10))
    mainPanel.add(createCounterRow("Counter 2"))
    mainPanel.add(Box.createVerticalStrut(10))
    mainPanel.add(createCounterRow("Counter 3"))

    frame.contentPane = mainPanel
    frame.pack()
    frame.setLocationRelativeTo(null)
    frame.isVisible = true
}

fun createCounterRow(title: String): JPanel {
    val panel = JPanel()
    panel.layout = BoxLayout(panel, BoxLayout.X_AXIS)

    val label = JLabel("$title: ")
    val minusButton = JButton("-")
    val plusButton = JButton("+")

    val textField = JTextField("0", 5)

    minusButton.addActionListener {
        val current = textField.text.toIntOrNull() ?: 0
        textField.text = (current - 1).toString()
    }

    plusButton.addActionListener {
        val current = textField.text.toIntOrNull() ?: 0
        textField.text = (current + 1).toString()
    }

    panel.add(label)
    panel.add(minusButton)
    panel.add(Box.createHorizontalStrut(8))
    panel.add(textField)
    panel.add(Box.createHorizontalStrut(8))
    panel.add(plusButton)

    return panel
}
