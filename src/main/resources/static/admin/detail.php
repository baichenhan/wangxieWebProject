<?php
    header('Content-Type:application/json');
    $array = [
            'id'            => 1,
            'username'       => 'juan1',
            'name'           => '汤伟诚',
            'role'           => 1,
            'sex'            => 1,
            'grade'            => '2018',
            'major'          => 3,
            'college'        => 9,
            'student_id'     => '201811130342',
            'department'     => 3,
            'QQ'             => '449097632',
            'status'         => 1,
            'ban_deadline'   => date('Y-m-d H:i:s')
    ];

    echo json_encode($array);
