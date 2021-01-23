<?php
    header('Content-Type:application/json');
    $array = [
        'code'    => 0,
        'msg'     => '',
        'count'   => 5,
        'data'    =>[
            [
                'id'        => '1',
                'p_menu'   => '一级菜单1',
                'menu'     => ''],
            [
                'id'        => '2',
                'p_menu'   => '',
                'menu'     => '|—二级菜单1'],
            [
                'id'        => '3',
                'p_menu'   => '',
                'menu'     => '|—二级菜单2'],
            [
                'id'        => '4',
                'p_menu'   => '一级菜单2',
                'menu'     => ''],
            [
                'id'        => '5',
                'p_menu'   => '',
                'menu'     => '|—二级菜单3']
        ]
    ];
    echo json_encode($array);