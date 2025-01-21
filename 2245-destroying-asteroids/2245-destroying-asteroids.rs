use std::collections::BinaryHeap;

impl Solution {
    pub fn asteroids_destroyed(mass: i32, asteroids: Vec<i32>) -> bool {
        // sort the asteroids
        let mut planet_mass = mass as i64;
        let mut asteroids = asteroids;
        asteroids.sort_unstable();
        for &curr in asteroids.iter(){
            if curr as i64 > planet_mass {
                return false;
            }
            planet_mass += curr as i64;
        }
        true

        // let mut spaceship_mass = mass;
    
        // for asteroid in asteroids {
        //     if spaceship_mass >= asteroid {
        //         spaceship_mass += asteroid; // spaceship destroys the asteroid and increases mass
        //     } else {
        //         return false; // spaceship cannot destroy the asteroid and gets destroyed
        //     }
        // }
    
        // true //
    }
}