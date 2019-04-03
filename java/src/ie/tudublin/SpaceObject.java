package ie.tudublin;


public abstract class SpaceObject
{
    protected UI ui;

    public SpaceObject(UI ui)
    {
        this.ui = ui;
    }

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }
    
}