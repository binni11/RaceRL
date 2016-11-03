/**
 * Created by brynjarolafsson on 03/11/16.
 */
enum Height {
    Short,
    Medium,
    Large
}
enum SkinColor {
    Blue,
    Green,
    Red
}
enum Ears{
    Pointy,
    Round,
    Cabbage
}
public class Features {

    Height height;
    SkinColor skincolor;
    Ears ears;

    public Features(Height height, SkinColor skincolor, Ears ears){
        this.height = height;
        this.skincolor = skincolor;
        this.ears = ears;
    }


}
