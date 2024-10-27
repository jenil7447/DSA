var mergeAlternately = function(word1, word2) {
    let merged = '';
    let minLength = Math.min(word1.length, word2.length);

    
    for (let i = 0; i < minLength; i++) {
        merged += word1[i] + word2[i];
    }

    
    merged += word1.substring(minLength) + word2.substring(minLength);

    return merged;
};
