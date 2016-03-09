import java.awt.Color

import scala.swing.{BorderPanel, BoxPanel, Button, FlowPanel, Frame, Label, MainFrame, Orientation, Swing}

trait AppMixin { app =>
  def title: String

  lazy val top: Frame = {
    val gg1 = Button("Foo")()
    val gg2 = Button("Bar")()
    val p1  = new BoxPanel(Orientation.Horizontal) {
      contents ++= Seq(gg1, gg2, Swing.HGlue)
    }
    val p2 = new FlowPanel(new Label("___________________"), Button("Baz")())
    p2.border = Swing.TitledBorder(Swing.LineBorder(Color.blue), "Title")
    val p3 = new BorderPanel {
      layout(p1) = BorderPanel.Position.North
      layout(p2) = BorderPanel.Position.Center
    }
    new MainFrame {
      title     = app.title
      contents  = p3
    }
  }
}
