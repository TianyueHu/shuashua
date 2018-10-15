class MergeIntervals_56{
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start, end = intervals.get(0).end;
        
        for(int i = 1; i < intervals.size(); ++i){
            Interval interval = intervals.get(i);
            if(interval.start > end){
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
                if(i == intervals.size() - 1){
                    result.add(interval);
                }
            }
            else{
                end = end > interval.end ? end : interval.end;
                if(i == intervals.size() - 1){
                    result.add(new Interval(start, end));
                }
            }
        }
        return result;
    }
}