package pack002.user;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Interval {

		private Date from;
		private Date to;
		private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy­-MM-­dd'T'HH'_'mm'_'ss.SSSZ");
		
		public Interval(Date from){
			setFrom(from);
			setTo(null);
		}
		
		public Date getFrom() {
			return from;
		}
		public void setFrom(Date from) {
			this.from = from;
			storeActivityInString();
		}
		public Date getTo() {
			return to;
		}
		public void setTo(Date to) {
			this.to = to;
		}
		
		public String storeActivityInString(){
			String activity = "";
			activity += ":" + dateFormat.format(from);
			if(to != null)
				activity += ":" + dateFormat.format(to);
			return activity;
		}
}
