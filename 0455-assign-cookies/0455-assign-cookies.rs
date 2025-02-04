impl Solution {
    pub fn find_content_children(mut g: Vec<i32>, mut s: Vec<i32>) -> i32 {
        let mut s_idx = 0;
        let mut g_idx = 0;

        g.sort_unstable();
        s.sort_unstable();

        let mut content = 0;
        while s_idx < s.len() && g_idx < g.len(){
            if s [s_idx] >= g[g_idx]{
                content+= 1;
                s_idx+= 1;
                g_idx += 1;
            }else{
                s_idx += 1;
            }
        }
        content
    }
}