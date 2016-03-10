import scala.swing.Swing._
import scala.swing._

trait AppMixin { app =>
  def title: String

  lazy val top: Frame = {
    val topPane = new BoxPanel(Orientation.Horizontal) {
      contents += new Button("Start")
      contents += HGlue
    }

    val bottomPane = new BoxPanel(Orientation.Horizontal) {
      contents += new Label("-------------- Audio Status --------------")
      contents += HGlue
    }

    val boxPane = new BoxPanel(Orientation.Vertical)
    boxPane.contents += topPane
    boxPane.contents += bottomPane

    new MainFrame {
      title     = app.title
      contents  = boxPane
    }
  }
}
