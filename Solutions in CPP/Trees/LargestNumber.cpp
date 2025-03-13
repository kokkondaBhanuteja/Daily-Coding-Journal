#include <bits/stdc++.h>
using namespace std;

// Binary Tree Node class structure
template <typename T>
class BinaryTreeNode {
public:
    T data;
    BinaryTreeNode<T>* left;
    BinaryTreeNode<T>* right;

    BinaryTreeNode(T data) {
        this->data = data;
        left = NULL;
        right = NULL;
    }
};

bool comp(string& s1, string& s2) {
    return (s1 + s2 > s2 + s1);
}

void inorder(vector<string>& nums, BinaryTreeNode<int>* root) {
    if (!root) {
        return;
    }
    nums.push_back(to_string(root->data));
    inorder(nums, root->left);
    inorder(nums, root->right);
}

string printLargest(BinaryTreeNode<int>* root) {
    vector<string> nums;
    inorder(nums, root);
    sort(nums.begin(), nums.end(), comp);
    string ans;
    for (string num : nums) {
        ans += num;
    }
    return ans[0] == '0' && ans.back() == '0' ? "0" : ans;
}

int main() {
    // Creating a sample binary tree
    BinaryTreeNode<int>* root = new BinaryTreeNode<int>(5);
    root->left = new BinaryTreeNode<int>(6);
    root->right = new BinaryTreeNode<int>(10);
    root->left->left = new BinaryTreeNode<int>(2);
    root->left->right = new BinaryTreeNode<int>(3);
	root->right->left = new BinaryTreeNode<int>(5);
    root->right->right = new BinaryTreeNode<int>(9);

    // Getting the largest concatenated number
    string result = printLargest(root);
    cout << "Largest concatenated number: " << result << endl;
   
    
    return 0;
}
