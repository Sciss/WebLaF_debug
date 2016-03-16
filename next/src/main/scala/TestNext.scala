import java.awt.Dimension
import javax.swing.JFrame

import com.alee.laf.WebLookAndFeel
import com.sun.awt.AWTUtilities

import scala.swing.SimpleSwingApplication

object TestNext extends SimpleSwingApplication with AppMixin {
  WebLookAndFeel.install()

  def title = "Next"

  override def startup(args: Array[String]): Unit = {
    JFrame.setDefaultLookAndFeelDecorated(true)
//    super.startup(args)
    val t = top
    AWTUtilities.setWindowOpaque ( t.peer, false )
    // t.peer.setUndecorated(true)
    t.peer.getRootPane.putClientProperty("styleId", "frame-decorated")
    // if (t.size == new Dimension(0,0))
    t.pack()
    t.centerOnScreen()
    t.visible = true
  }
}