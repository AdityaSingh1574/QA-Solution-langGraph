import json
import os
from prompts.reply_prompts import GREETING_REPLY_PROMPT, SIMPLE_INSTRUCTIONS_REPLY_PROMPT





def extract_text_between_markers(input_text:str, start_marker:str, end_marker:str)->str:

    # Finding the start and end indices of the markers
    start_index = input_text.find(start_marker) + len(start_marker)
    end_index = input_text.find(end_marker, start_index)

    # If either marker is not found, return an empty string
    if start_index == -1 or end_index == -1:
        return ""

    # Extracting the text between the markers
    return input_text[start_index:end_index].strip()


def prepare_reply(classified_type:str, missing_params:str)->str:
    
    if classified_type == 'simple instructions':
        return SIMPLE_INSTRUCTIONS_REPLY_PROMPT.format(missing_params=missing_params)
    else:
        return GREETING_REPLY_PROMPT