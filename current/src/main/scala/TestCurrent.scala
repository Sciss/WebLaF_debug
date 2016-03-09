import com.alee.laf.WebLookAndFeel

import scala.swing.SimpleSwingApplication

object TestCurrent extends SimpleSwingApplication with AppMixin {
  WebLookAndFeel.install()

  def title = "Current"
}