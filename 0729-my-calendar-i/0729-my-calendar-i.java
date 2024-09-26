class MyCalendar {
    class Event implements Comparable<Event> {
        int start;
        int end;

        Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Event event) {
            if(this.start == event.start) {
                return Integer.compare(this.end, event.end);
            }

            return Integer.compare(this.start, event.start);
        }
    }

    List<Event> events;
    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(isPossible(start, end)) {
            events.add(new Event(start, end));
            Collections.sort(events);
            return true;
        } else {
            return false;
        }
    }

    boolean isPossible(int start, int end) {
        int left = 0;
        int right = events.size()-1;

        while(left <= right) {
            int mid = (right + left)/2;
            Event midEvent = events.get(mid);

            // check overlap
            // 3 possibilities:
            // 1. before start and ends after start and before end
            // 2. after start and ends after end
            // 3. after start and before end
            if(
                (start <= midEvent.start && end > midEvent.start) ||
                (start >= midEvent.start && start < midEvent.end) ||
                (start >= midEvent.start && end <= midEvent.end)
            ) {
                return false;
            } 

            // go left
            if(midEvent.start >= end) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */