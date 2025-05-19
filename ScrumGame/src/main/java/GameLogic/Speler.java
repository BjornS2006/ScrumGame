package GameLogic;
import java.util.ArrayList;
import java.util.List;

    public class Speler {
        private Status status;

        public Speler (Status status) {
            this.status = status;
        }

        public Status getStatus () {
            return status;
        }
        public void setStatus (Status status) {
            this.status = status;
        }
}
