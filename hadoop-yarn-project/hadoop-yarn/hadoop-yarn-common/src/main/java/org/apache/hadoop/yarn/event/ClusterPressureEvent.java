package org.apache.hadoop.yarn.event;

public class ClusterPressureEvent extends AbstractEvent<ClusterPressureEventType>{

	public int requestedContainers,numApps;

	public ClusterPressureEvent(ClusterPressureEventType type){
		super(type);
		if(type == ClusterPressureEventType.NO_PRESSURE)
			this.requestedContainers = 0;
		else
			this.requestedContainers = Integer.MAX_VALUE;
	}

	public ClusterPressureEvent(ClusterPressureEventType type, int numContainers){
		super(type);
		if(numContainers <= 0){
			this.requestedContainers = Integer.MAX_VALUE;
		}
		else{
			this.requestedContainers = numContainers;
		}
		this.numApps = numApps;
	}

	@Override
	public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof ClusterPressureEvent)) {
            return false;
        }
         
        ClusterPressureEvent r = (ClusterPressureEvent) o;
         
        return (r.getType() == this.getType() && r.requestedContainers == this.requestedContainers);
	}
	
}
