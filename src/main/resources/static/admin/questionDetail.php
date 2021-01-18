<?php
    header('Content-Type:application/json');
    $array = [
            'id'            => 1,
            'question'       => '一个问题的题目',
            'status'            => 1
    ];

    echo json_encode($array);
