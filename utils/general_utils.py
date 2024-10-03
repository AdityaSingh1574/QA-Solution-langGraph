import json
import os







def extract_text_between_markers(input_text, start_marker, end_marker):

    # Finding the start and end indices of the markers
    start_index = input_text.find(start_marker) + len(start_marker)
    end_index = input_text.find(end_marker, start_index)

    # If either marker is not found, return an empty string
    if start_index == -1 or end_index == -1:
        return ""

    # Extracting the text between the markers
    return input_text[start_index:end_index].strip()