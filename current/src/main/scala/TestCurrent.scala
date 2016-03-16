import java.awt.Dimension
import javax.swing.JFrame

import com.alee.laf.WebLookAndFeel

import scala.swing.SimpleSwingApplication

object TestCurrent extends SimpleSwingApplication with AppMixin {
  WebLookAndFeel.install()

  def title = "Current"

  override def startup(args: Array[String]): Unit = {
    JFrame.setDefaultLookAndFeelDecorated(true)
//    super.startup(args)
    val t = top
    if (t.size == new Dimension(0,0)) t.pack()
    t.peer.getRootPane.putClientProperty("styleId", "frame-decorated")
    t.visible = true
  }
}