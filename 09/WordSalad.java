/* File: WordSalad.java - April 2018 */
package week09;

/**
 *  Implementation of the WordSalad application that Creates a singly linked
 *  list called a WordSalad. Contains methods for scrambling a WordSalad into
 *  different variations of arrays of WordSalad objects. Also contains methods
 *  for reassembling the scrambled WordSalad arrays.
 *
 *  @author Michael Albert, Mitch Abel
 */
public class WordSalad implements Iterable<String> {

    /** A WordNode object containing the first word in the WordSalad. */
    private WordNode first;
    /** A WordNode object containing the last word in the WordSalad. */
    private WordNode last;

    /**
     *  Creates an empty WordSalad object.
     */
    public WordSalad() {
        this.first = null;
        this.last = null;
    }

    /**
     *  Creates a WordSalad object containing a given list of words.
     *
     * @param words A list of Strings to be added to the WordSalad.
     */
    public WordSalad(java.util.List<String> words) {
        for (String word : words) {
            addLast(word);
        }
    }

    /**
     *  Adds a word to the beggining of a WordSalad by setting the first
     *  WordNode's word to the given word.
     *
     * @param word A string to be added to the the WordSalad.
     */
    public void add(String word) {
        if (this.first == null) {
            this.first = new WordNode(word, null);
            this.last = this.first;
            return;
        }
        WordNode newFirst = new WordNode(word, this.first);
        this.first = newFirst;
    }

    /**
     *  Adds a word to the end of a WordSalad by setting the first WordNode's
     *  word to a given word if the first WordNode is empty, or setting the last
     *  WordNode's word to a given word if the first WordNode is NOT empty.
     *
     * @param word A String to be added to the WordSalad.
     */
    public void addLast(String word) {
        if (this.first == null) {
            add(word);
            return;
        }
        WordNode newLast = new WordNode(word, null);
        this.last.next = newLast;
        this.last = newLast; 
    }

    /**
     *  Implementation of the WordNode application that creates an object
     *  containing a reference to a String <code>word</code> and a pointer
     *  to the <code>next</code> WordNode.
     */
    private class WordNode {
        /** The word that the WordNode refers to. */
        private String word;
        /** A pointer to the next WordNode after this one. */
        private WordNode next;

        /**
         *  Creates a WordNode object containing a given word and a given
         *  pointer to the next WordNode object.
         *
         * @param word A String to add to the WordNode.
         * @param next A pointer to the next WordNode.
         */
        private WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }
        
    }

    /**
     *  A custom iterator to iterate over WordNode objects.
     *
     * @return An iterator over WordNode objects.
     */
    public java.util.Iterator<String> iterator() {
        return new java.util.Iterator<String>() {
            private WordNode current = first;
      
            public boolean hasNext() {
                return current != null;
            }
      
            public String next() {
                String result = current.word;
                current = current.next;
                return result;
            }
      
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /**
     *  A toString method that converts a WordSalad to a String.
     *
     * @return The String of words surrounded by "[]" and seperated by ", ".
     */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        WordNode node = first;
        while (node != null) {
            result.append(node.word);
            result.append(node.next == null ? "" : ", ");
            node = node.next;
        }
        return result.toString() + "]";
    }

    /**
     *  Counts the number of words in the WordSalad object from a given
     *  node in the WordSalad.
     *
     * @param firstNode The WordNode to start counting from.
     * @return The amount of words in the WordSalad from the given node.
     */
    public int wordCount(WordNode firstNode) {
        int wordCount = 0;
        WordNode n = firstNode;
        while (n != null) {
            wordCount++;
            n = n.next;
        }
        return wordCount;
    }

    /**
     *  Creates an array of k amounts of WordSalads. These are populated with
     *  words from a WordSalad. The first word goes in the first WordSalad, the
     *  second word in the second WordSalad and so on until k is reached then
     *  start again from the first WordSalad until there are no more words in
     *  the original WordSalad. This works like dealing cards.
     *
     * @param k the amount of WordSalads to be put into an array.
     * @return An array of "distributed" WordSalads.
     */
    public WordSalad[] distribute(int k) {
        WordSalad[] distributed = new WordSalad[k];

        while (first != null) {
            for (int i = 0; i < k; i++) {
                if (distributed[i] == null) {
                    distributed[i] = new WordSalad();
                }
                distributed[i].addLast(first.word);
                if (first.next != null) {
                    first = first.next;
                } else {
                    return distributed;
                }
            }
        }
        return distributed;
    }

    /**
     *  Creates an array of k amounts of WordSalads. These are populated with
     *  words form a WordSalad. The amount of words in each WordSalad is first
     *  determined by finding a small WordSalad size, a large WordSalad size,
     *  and the ammounts of both. This ensures that the words are divided into
     *  k nearly equal pieces. The words then added to the first block in order
     *  until it reaches it's determined size, then they are added to the second
     *  block and so on until there are no more words in the original WordSalad.
     * @param k the amount of WordSalads to be put into an array.
     * @return An array of "chopped" WordSalads.
     */
    public WordSalad[] chop(int k) {
        WordSalad[] chopped = new WordSalad[k];
        
        int wordCount = wordCount(first);

        /** determines small WordSalad size by dividing the number of words
         *  by k */
        int sizeTwo = wordCount/k;
        
        /** determines large WordSalad size by adding one to small
         *  WordSalad size */
        int sizeOne = sizeTwo+1;
        
        /** determines the number of small WordSalads by subtracting the
         *  remainder of the number of words divided by k, from k. */
        int freqTwo = k-(wordCount%k);
        
        /** determines the number of large WordSalads by finding the remainder
         *  from the division of the number of words by k*/
        int freqOne = wordCount%k;
        
        int blockIndex = 0;
        
        for (int g = freqOne; g > 0; g--) {
            for (int h = sizeOne; h > 0; h--) {
                if (chopped[blockIndex] == null) {
                    chopped[blockIndex] = new WordSalad();
                }
                chopped[blockIndex].addLast(first.word);
                first = first.next;
            }
            blockIndex++;
        }
        for (int i = freqTwo; i > 0; i--) {
            for (int j = sizeTwo; j > 0; j--) {
                if (chopped[blockIndex] == null) {
                    chopped[blockIndex] = new WordSalad();
                }
                chopped[blockIndex].addLast(first.word);
                first = first.next;
            }
            blockIndex++;
        }
        return chopped;
    }

    /**
     *  Creates an array of WordSalads. The number of WordSalads in this array
     *  is determined by how many times w - (w/k)+1 can happen before w is equal
     *  to 0, where w is the number of words in the original WordSalad and k is
     *  a given integer. The original WordSalad is iterated through repeatedly.
     *  If the current word's posistion in the WordSalad is the first position
     *  or is evenly divisible by k, it is added to the first block until the
     *  end of the original WordSalad is reached, Any words added to the array
     *  are removed from the original WordSalad. The new WordSalad is then
     *  itterated through. This continues until the original WordSalad is empty.
     *
     * @param k The index for which words will be added to the array from the
     *        orginal WordSalad after k iterations.
     * @return An array of "split" WordSalads.
     */
    public WordSalad[] split(int k) {
        int w = wordCount(first);
        int blockCount = 1;
        while (w > 0) {
            w -= (w/k)+1;
            blockCount++;
        }
        
        WordSalad[] split = new WordSalad[blockCount];
        WordSalad updatedSalad = new WordSalad();
        WordSalad updater = new WordSalad();
        updatedSalad.first = first;
        int arrayIndex = 0;
        
        while (updatedSalad.first != null) {
            int wordCount = wordCount(updatedSalad.first);

            for (int j = 0; j < wordCount; j++) {
                if (j%k == 0) {
                    if (split[arrayIndex] == null) {
                        split[arrayIndex] = new WordSalad();
                    }
                    split[arrayIndex].addLast(updatedSalad.first.word);
                    updatedSalad.first = updatedSalad.first.next;
                } else {
                    updater.addLast(updatedSalad.first.word);
                    updatedSalad.first = updatedSalad.first.next;
                }
            }
            updatedSalad.first = updater.first;
            updater.first = null;
            arrayIndex++;
        }
        return split;
    }

    /**
     *  Creates a new WordSalad object consisting of words from different
     *  WordSalads contained in an array. To merge an array of WordSalads,
     *  the first word from the first WordSalad, the first word from the second
     *  WordSalad and so on until there are no WordSalads left in the array.
     *  These words are added to the new WordSalad and the iteration starts
     *  again with the second word from each WordSalad. This continues until all
     *  WordSalads in the array are empty.
     *
     * @param blocks The array of WordSalads to be merged.
     * @return A "merged" WordSalad.
     */
    public static WordSalad merge(WordSalad[] blocks) {
        WordSalad saladMerge = new WordSalad();
        int emptyPointer = 0;
        
        while (blocks.length > emptyPointer) {
            for (int i = 0; i < blocks.length; i++) {
                if (blocks[i].first != null) {
                    saladMerge.addLast (blocks[i].first.word);
                    if (blocks[i].first.next != null) {
                        blocks[i].first = blocks[i].first.next;
                    } else {
                        emptyPointer++;
                    }
                    if (emptyPointer == blocks.length) {
                        return saladMerge;
                    }
                }
            }
        }  return saladMerge;
    }   

    /**
     *  Creates a new WordSalad object consisting of words from different
     *  WordSalads contained in an array. Each WordSalad in the array is
     *  ittereated through with it's words being added to the new WordSalad
     *  in order.
     *
     * @param blocks An array of WordSalad objects.
     * @return A "joined" WordSalad.
     */
    public static WordSalad join(WordSalad[] blocks) {
        WordSalad w = new WordSalad();
        for (WordSalad block : blocks) {
            for (String s: blocks) {
                w.addLast(s);
            }
        }
        return w;
    }

    public static WordSalad recombine(WordSalad[] blocks, int k) {
        return null;
    }
}
