import java.awt.{Color, Graphics}
import javax.swing.JPanel
import javax.swing.border.Border

import scala.swing.{Component, BorderPanel, BoxPanel, Button, FlowPanel, Frame, Label, MainFrame, Orientation, Swing}

trait AppMixin { app =>
  def title: String

  lazy val top: Frame = {
    val gg1 = Button("Foo")()
    val gg2 = Button("Bar")()
    val p1  = new BoxPanel(Orientation.Horizontal) {
      contents ++= Seq(gg1, gg2, Swing.HGlue)
    }
    val gg3 = new Label("___________________")
    val gg4 = Button("Baz")()

    val p2j = new JPanel(new java.awt.FlowLayout) {
      override def paint(g: Graphics): Unit = {
        // overridden to allow breakpoint for debugger
        println("paint")
        super.paint(g)
      }

      override def setBorder(border: Border): Unit = {
        println("setBorder")
        super.setBorder(border)
      }
    }
    p2j.add(gg3.peer)
    p2j.add(gg4.peer)

    val p2 = Component.wrap(p2j)
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
