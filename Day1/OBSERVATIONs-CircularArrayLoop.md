## CircularArrayLoop: Learning Points

**Key Takeaways**

* **Slow and Fast Pointer Approach:** For detecting loops, the classic approach using slow and fast pointers is often effective and efficient. I missed the opportunity to apply this technique in my implementation.
* **Visualizing Edge Cases:** It's crucial to visualize and consider edge cases thoroughly. I struggled to visualize the behavior for one-element cycles, leading to incorrect logic.
* **ChatGPT as a Learning Tool:** The ChatGPT-generated solution provided a more intuitive approach, highlighting the importance of leveraging external resources and learning from different perspectives.

**Understanding Negative Indices**

The correct handling of negative indices is fundamental for solving the CircularArrayLoop problem. The "wrapping" logic is essential to maintain the circular nature of the array:

* **Calculating Next Index:**
    - `next = (current + nums[current]) % n` calculates the raw next index.
    - The modulo operator (`%`) ensures that the index remains within the bounds of the array.

* **Handling Negative Indices:**
    - If `next` is negative, we add `n` to it to "wrap" the index back to the end of the array.
    - This ensures that negative indices are correctly mapped to their corresponding positions in the circular array.

**Example Walkthrough:**

The provided examples demonstrate how the wrapping logic works in practice, illustrating the correct handling of negative indices and maintaining the circular behavior of the array.