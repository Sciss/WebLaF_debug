import java.awt._
import javax.swing.border.Border
import javax.swing.{JRootPane, JFrame, JLabel, WindowConstants}

import com.alee.laf.WebLookAndFeel
import com.sun.awt.AWTUtilities

import scala.swing
import scala.swing.{Swing, BorderPanel, Button}

object WindowBordersNext extends App with Runnable {
  WebLookAndFeel.install()
  JFrame.setDefaultLookAndFeelDecorated(true)
  EventQueue.invokeLater(this)

  def run(): Unit = {
    val t = new JFrame {
      override def paint(g: Graphics): Unit = {
//        println("repaint")
        super.paint(g)
//        val g2d = g.asInstanceOf[Graphics2D]
//        val compOrig = g2d.getComposite
//        g2d.setComposite(AlphaComposite.Src)
//        val w = getWidth
//        val h = getHeight
//        g2d.setColor(new Color(0, 0, 0, 0x3F))
////        g2d.fillRect(0, 0, w, h)
//        g2d.setComposite(compOrig)
//        g2d.fillRect(0, 0, w, h)
//        if (!isOpaque) {
//          val gg: Graphics = g // g.create()
//          try {
//            if (gg.isInstanceOf[Graphics2D]) {
//              gg.setColor(getBackground)
//              (gg.asInstanceOf[Graphics2D]).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC))
//              gg.fillRect(0, 0, getWidth, getHeight)
//            }
//          } finally {
//            // gg.dispose()
//          }
//        }
      }
    }

    val bd = new Border {
      def paintBorder(c: Component, g: Graphics, x: Int, y: Int, width: Int, height: Int): Unit = {
        val g2d = g.asInstanceOf[Graphics2D]
        val compOrig = g2d.getComposite
        g2d.setComposite(AlphaComposite.Src)
        g2d.setColor(new Color(0, 0, 0, 0x20))
        g2d.fillRect(x, y, width, 32)
        g2d.fillRect(x, y + 32, 32, height - 64)
        g2d.fillRect(x + width - 32, y + 32, 32, height - 64)
        g2d.fillRect(x, y + height - 32, width, 32)

        g2d.setColor(new Color(0, 0, 0, 0x40))
        g2d.fillRect(x + 16, y + 16, width - 32, 16)
        g2d.fillRect(x + 16, y + 32, 16, height - 64)
        g2d.fillRect(x + width - 32, y + 32, 16, height - 64)
        g2d.fillRect(x + 16, y + height - 32, width, 16)

        g2d.setComposite(compOrig)
      }

      def isBorderOpaque: Boolean = false

      def getBorderInsets(c: Component): Insets = new Insets(32, 32, 32, 32)
    }

    t.getRootPane.setWindowDecorationStyle(JRootPane.NONE)  // bug in WebLaF
    t.getRootPane.putClientProperty("styleId", "frame-decorated")
    t.pack()  // avoid repaint bug when using LaF-decoration
    AWTUtilities.setWindowOpaque(t, false)
//    println("Opaque? " + t.isOpaque)
    t.setTitle("Title")
    val but = Button("Repaint")(t.repaint())
    val p = new BorderPanel {
      border = Swing.EmptyBorder(32)
//      border = bd // Swing.EmptyBorder(32)
      add(but, BorderPanel.Position.Center)

      override protected def paintComponent(g: swing.Graphics2D): Unit = {
        super.paintComponent(g)
        bd.paintBorder(peer, g, 0, 0, peer.getWidth, peer.getHeight)
      }
    }
    t.getContentPane.add(p.peer)
    t.setBounds(new Rectangle(400, 400, 400, 200))
    t.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    // t.setOpacity(0.99f)
    t.setVisible(true)
  }
}