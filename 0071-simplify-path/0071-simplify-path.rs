impl Solution {
    pub fn simplify_path(path: String) -> String {
        let mut file_path = Vec::new();
        for ch in path.split('/'){
            match ch{
                "" | "." => continue,
                ".." => { file_path.pop(); },
                _ => file_path.push(ch),
            }
        }
        let simplified = "/".to_string() + &file_path.join("/");
        simplified
    }
}