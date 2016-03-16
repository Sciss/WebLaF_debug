import java.awt.{EventQueue, Rectangle}
import javax.swing.{JFrame, JLabel, WindowConstants}

import com.alee.laf.WebLookAndFeel

object WindowBorders extends App with Runnable {
  WebLookAndFeel.install()
  JFrame.setDefaultLookAndFeelDecorated(true)
  EventQueue.invokeLater(this)

  def run(): Unit = {
    val t = new JFrame
    t.pack()  // avoid repaint bug when using LaF-decoration
    t.setTitle("Title")
    t.getContentPane.add(new JLabel("Test one two."))
    t.setBounds(new Rectangle(400, 400, 400, 200))
    t.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    // t.setOpacity(0.99f)
    t.setVisible(true)
  }
}