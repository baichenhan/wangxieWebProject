<?php
    header('Content-Type:application/json');
    $array = [[
            'value' => '9',
            'name' => '车院',
            'major'=> [
                ['value' => '1', 'name' => '车辆工程'],
                ['value' => '2', 'name' => '能源与动力工程'],
                ['value' => '3', 'name' => '石油工程']
            ]
        ], [
            'value' => '10',
            'name' => 'A院',
            'major'=> [
                ['value' => '4', 'name' => 'A1'],
                ['value' => '5', 'name' => 'A2'],
                ['value' => '6', 'name' => 'A3']
            ]
        ], [
            'value' => '11',
            'name' => 'C院',
            'major'=> [
                ['value' => '7', 'name' => 'C1'],
                ['value' => '8', 'name' => 'C2']
            ]
        ]
    ];
    echo json_encode($array);