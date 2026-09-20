class LUPrefix {

    boolean[] uploaded;
    int longestVideo;

    public LUPrefix(int n) {
        uploaded = new boolean[n + 1];
        longestVideo = 0;
    }
    
    public void upload(int video) {
        uploaded[video] = true;

        while(longestVideo + 1 < uploaded.length
              && uploaded[longestVideo + 1]) {

            longestVideo++;
        }
    }
    
    public int longest() {
        return longestVideo;
    }
}