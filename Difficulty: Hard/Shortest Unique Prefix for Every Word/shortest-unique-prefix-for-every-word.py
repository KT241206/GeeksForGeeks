class TrieNode:
    def __init__(self):
        self.child = {}
        self.count = 0

class Solution:
    def findPrefixes(self, arr):
        root = TrieNode()

        # Insert all words into Trie
        for word in arr:
            node = root
            for ch in word:
                if ch not in node.child:
                    node.child[ch] = TrieNode()
                node = node.child[ch]
                node.count += 1

        # Find shortest unique prefix
        ans = []

        for word in arr:
            node = root
            prefix = ""

            for ch in word:
                node = node.child[ch]
                prefix += ch
                if node.count == 1:
                    break

            ans.append(prefix)

        return ans