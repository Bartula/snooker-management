package recruitmenttask.snookermanagement.api;

/**
 * Created by Bartosz on 2017-01-28.
 */
public class CreateFrameRequest {

    private FrameDTO frame;

    public FrameDTO getFrame() {
        return frame;
    }

    public void setFrame(FrameDTO frame) {
        this.frame = frame;
    }

    public Long getPLayerAScore(){
        return frame.getPlayerAScore();
    }

    public Long getPLayerBScore(){
        return frame.getPlayerBScore();
    }

    public void validate() throws InvalidRequestException{
        if (frame == null)
            throw new InvalidRequestException("frame is required");
        frame.validate();
    }
}
