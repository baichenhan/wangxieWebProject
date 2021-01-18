<?php
    header('Content-Type:application/json');
    $array = [[
            'department' => '运维部',
            'user'=> [
                ['user_id' => '1', 'user_name' => 'YYYY1'],
                ['user_id' => '2', 'user_name' => 'YYYY2'],
                ['user_id' => '3', 'user_name' => 'YYYY3']
            ]
        ], [
            'department' => '开发部',
            'user'=> [
                ['user_id' => '4', 'user_name' => 'KKKK1'],
                ['user_id' => '5', 'user_name' => 'KKKK2'],
                ['user_id' => '6', 'user_name' => 'KKKK3']
            ]
        ], [
            'department' => '组宣部',
            'user'=> [
                ['user_id' => '7', 'user_name' => 'zzzz1'],
                ['user_id' => '8', 'user_name' => 'zzzz2']
            ]
        ]
    ];
    echo json_encode($array);