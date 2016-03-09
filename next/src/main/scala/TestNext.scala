import com.alee.laf.WebLookAndFeel

import scala.swing.SimpleSwingApplication

object TestNext extends SimpleSwingApplication with AppMixin {
  WebLookAndFeel.install()

  def title = "Next"
}