/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }
    
    let count = {};
    
    
    for (let i = 0; i < s.length; i++) {
        let c = s[i];
        if (count[c]) {
            count[c] += 1;
        } else {
            count[c] = 1;
        }
    }
    
    
    for (let i = 0; i < t.length; i++) {
        let c = t[i];
        if (!count[c]) {
            return false;
        }
        count[c] -= 1;
    }
    
    return true;
};
