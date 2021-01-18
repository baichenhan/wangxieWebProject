<?php
    header('Content-Type:application/json');
    $array = [
        'code'    => 0,
        'msg'     => '',
        'count'   => 6,
        'data'    => [
            [
                'id'            => 1,
                'question'       => '一个问题的题目',
                'status'            => '启用'],
            [
                'id'            => 1,
                'question'       => '一个问题的题目',
                'status'            => '启用'],
            [
                'id'            => 1,
                'question'       => '一个问题的题目',
                'status'            => '启用'],
            [
                'id'            => 1,
                'question'       => '一个问题的题目',
                'status'            => '启用'],
            [
                'id'            => 1,
                'question'       => '一个问题的题目',
                'status'            => '启用'],
            [
                'id'            => 1,
                'question'       => '一个问题的题目',
                'status'            => '启用']
        ]
    ];

    echo json_encode($array);

